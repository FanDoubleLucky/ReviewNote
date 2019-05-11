package Foundation.ThreadPackage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest{
    static int N_CPU = Runtime.getRuntime().availableProcessors();
    static ThreadPoolExecutor tpe = new ThreadPoolExecutor(2,N_CPU*2,4, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(N_CPU*8),new ThreadPoolExecutor.CallerRunsPolicy());
    public static void main(String[] args) {
        tpe.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
                for (;;){}
            }
        });
        tpe.shutdown();
    }


}
