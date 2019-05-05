package Foundation.ThreadPackage;

import java.util.concurrent.locks.*;

public class ReentrantLockTest {

    static ReentrantLock defaultLock = new ReentrantLock();//默认非公平
    static ReentrantLock fairLock = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(fairLock.isLocked());
                fairLock.lock();
//                fairLock.tryLock();如果是tryLock，程序就不会死掉，tryLock只会在锁没有被占有时才尝试去获取
            }
        });
        thread.start();
        Thread.sleep(1000);
        fairLock.lock();//程序会卡在这里
        System.out.println("wait "+fairLock.getQueueLength());
        fairLock.getHoldCount();

        fairLock.unlock();
        defaultLock.lock();

        System.out.println(fairLock.getQueueLength());


    }
}
