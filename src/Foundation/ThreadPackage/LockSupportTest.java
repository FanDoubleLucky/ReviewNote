package Foundation.ThreadPackage;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    static Thread mainThread;
    public static void main(String[] args) {
        mainThread = Thread.currentThread();
        ThreadA th = new ThreadA();
        th.start();
        System.out.println("MainThread Blocked");
        LockSupport.park(mainThread);
        System.out.println("MainThread continue");
    }


    static class ThreadA extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {}
            System.out.println("th Thread unpark MainThread");
            LockSupport.unpark(mainThread);
            System.out.println(LockSupport.getBlocker(mainThread));
        }
    }
}
