package Foundation;

import java.util.concurrent.atomic.AtomicInteger;

public class atomic {
//    public static Integer i = new Integer(0);
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new runnab());
        Thread t2 = new Thread(new runnab());
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(runnab.i);
    }
}


class runnab implements Runnable{
    static AtomicInteger i = new AtomicInteger(0);
    public void run(){
        for (int j = 0; j < 100; j++) {
            runnab.i.incrementAndGet();
//            atomic.i++;
        }
    }
}
