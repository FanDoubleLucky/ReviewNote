package Foundation.ThreadPackage;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(5);
    public static void main(String[] args) {
        SubThread th = new SubThread();
        th.start();
        try {
            countDownLatch.await();//在countdownlatch减到0之前会一直阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(countDownLatch.getCount());
    }

    static class SubThread extends Thread{
        @Override
        public void run() {
            System.out.println("Sub Thread count down");
            for (int i = 0; i < 10; i++) {
                countDownLatch.countDown();//虽然countdown被执行了10次，大于构造函数里的5，但是依然是当countdown到0时，await的线程就唤醒了，多countdown也不会有异常，没啥用
            }
        }
    }
}
