package Foundation.ThreadPackage;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试lockInterruptibly()函数，线程在等待获取lock中或者在执行lockInterruptibly前如果被中断此线程将不会在等待，直接抛出interruptException异常,注意此时虽然执行了interrupt但是因为抛出了异常所以isinterrupt标志位还是false
 */
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
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" doesn't wait");
            System.out.println(Thread.currentThread().getName()+" is interrupt "+Thread.currentThread().isInterrupted());
            super.run();
        }
    }
}
