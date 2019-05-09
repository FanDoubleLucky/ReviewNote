package Foundation.ThreadPackage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class tryLockTest {

    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {

        lock.lock();
        MyThread th = new MyThread();
        th.start();
        lock.unlock();
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            lock.lock();
            System.out.println(lock.tryLock());
            System.out.println(lock.getHoldCount());//这句证明tryLock在重入时和lock一样也会增加holdcount
            System.out.println("Running");//如果上面不用tryLock而用lock，这句sout就会被阻塞,tryLock只会尝试一次，如果拿不到就直接拜拜执行下面的
        }
    }
}
