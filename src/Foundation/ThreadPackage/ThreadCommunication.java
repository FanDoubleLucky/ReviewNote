package Foundation.ThreadPackage;

import java.util.ArrayList;

public class ThreadCommunication {


    public static void main(String[] args) {
        Factory f = new Factory();
        Thread t1 = new Thread(new Runnable() {
            boolean stopFlag = false;
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()){
                        f.produce();
                    }
                } catch (InterruptedException e) {
                    System.out.println();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            boolean stopFlag = false;
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()){
                        f.consume();
                    }
                } catch (InterruptedException e) {
                    System.out.println();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            boolean stopFlag = false;
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()){
                        f.consume();
                    }
                } catch (InterruptedException e) {
                    System.out.println();
                }
            }
        });

        ArrayList<Thread> Ts = new ArrayList<Thread>();
        Ts.add(t1);
        Ts.add(t2);
        Ts.add(t3);

        for (Thread t:
             Ts) {
            t.start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Thread t:
                Ts) {
            t.interrupt();
        }
    }
}

class Factory {

    private int product = 0;
    static int MAX_PRODUCT = 150;
    static int MIN_PRODUCT = 3;
    Object lock1 = new Object();
    Object lock2 = new Object();
    public  void produce() throws InterruptedException {
        synchronized(this) {
            while (this.product >= MAX_PRODUCT) {
                System.out.println("货满了");
                wait();
            }
            this.product++;
            System.out.println("生产了第" + this.product + "货物");
            notifyAll();
        }
    }

    public synchronized void consume() throws InterruptedException {

            while (this.product < MIN_PRODUCT) {
                System.out.println("待补货");
                wait();
            }
            System.out.println("消费了第" + this.product + "货物");
            this.product--;
            notifyAll();

    }
}
