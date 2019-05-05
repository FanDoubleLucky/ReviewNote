package Foundation.ThreadPackage;

/**
 * 这个程序展示了sleeping的线程调用interrupt方法会报interruptException，但是interrupt标志位不会被置为true
 */
public class InterruptException {

    public static void main(String[] args) {
        MyThread th = new MyThread();
        th.start();
        th.interrupt();
        System.out.println("Main"+th.isInterrupted());
//        th.interrupt();

    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            int i= 100000000;
            while(i>0){
                i--;
            }
            System.out.println("TH"+i);
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }

            while(!Thread.currentThread().isInterrupted()){

            }
        }
    }
}
