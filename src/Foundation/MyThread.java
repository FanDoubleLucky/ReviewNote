package Foundation;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyThread {

    public static void main(String[] args) {
        MyThread myT = new MyThread();

        //继承Thread父类创建线程
        ThreadClass t1 = myT.new ThreadClass();
        t1.start();
        t1.interrupt();//interrupt不会真正中断任何进程

        //Runnable创建线程
        Thread t2 = new Thread(myT.new ThreadRunnable());
        t2.start();

        //Callable FutureTask创建线程
        ThreadCallable t3 = myT.new ThreadCallable();
        FutureTask<Integer> ft = new FutureTask<Integer>(t3);
        Thread ftThread = new Thread(ft, "FutureTaskThread");
        ftThread.start();
        ftThread.interrupt();
        System.out.println(t3.i);
    }

    public class ThreadClass extends Thread{
        public void run() {
            try {
                int i = 0;
                //Thread.sleep(2000);
                //配合interrupt()在程序逻辑上中断进程
                while(!isInterrupted()){
                    i++;
                }
                System.out.println(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class ThreadRunnable implements Runnable{
        public void run(){
            System.out.println("Runnable");
        }
    }

    public class ThreadCallable implements Callable{
        public int i = 0;
        public Integer call(){
            while(!Thread.currentThread().isInterrupted()){
                i++;
            }
            return i;
        }
    }
}
