package Foundation.ThreadPackage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantRWLock {

    static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    public static void main(String[] args) {

        MyThread th = new MyThread();

        Lock readL = rw.readLock();
        Lock writeL = rw.writeLock();

        writeL.lock();
        readL.lock();
        th.start();
        writeL.unlock();
//        readL.unlock();
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            rw.readLock().lock();
            System.out.println("SubThread read lock");
        }
    }
}
