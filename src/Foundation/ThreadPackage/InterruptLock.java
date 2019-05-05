package Foundation.ThreadPackage;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptLock {

    static ReentrantLock lock = new ReentrantLock(true);
    public static void main(String[] args) throws InterruptedException {
        ThreadLockIn t1 = new ThreadLockIn("T1");
        ThreadLockIn t2 = new ThreadLockIn("T2");
        t1.start();
        Thread.sleep(500);

        t2.start();
        t2.interrupt();

    }

    static class ThreadLockIn extends Thread{
        public ThreadLockIn(String name){
            super(name);
        }
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+" Try get lock");
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" doesn't wait");
            super.run();
        }
    }
}
