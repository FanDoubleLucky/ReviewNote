package Foundation.ThreadPackage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    public static void main(String[] args){
        ThreadA th = new ThreadA();
        lock.lock();
        th.start();
        System.out.println("th Thread start");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    static class ThreadA extends Thread{
        @Override
        public void run() {
            lock.lock();
            System.out.println("th Thread catches lock");
            condition.signal();
            lock.unlock();
            System.out.println("th Thread releases lock");

        }
    }
}
