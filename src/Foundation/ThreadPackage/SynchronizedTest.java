package Foundation.ThreadPackage;

public class SynchronizedTest {
//    public void testPublic(){
//        test();
//    }
    public static void main(String[] args) throws InterruptedException {

        final synchronizedMethod sy = new synchronizedMethod();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                sy.test();
                sy.test1();
            }
        }, "ThreadI");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sy.test();
                sy.test1();
            }
        }, "ThreadII");
//        t1.setPriority(10);//setPriority不能保证有作用
//        t2.setPriority(Thread.MIN_PRIORITY);


        t1.start();
        t2.start();



//        t1.sleep(1000);//t1不会sleep sleep的是main
//        t1.yield();//yield的也不是t1，而是main

    }




    public static class ThreadClass implements Runnable{
        synchronizedMethod sy;
        public void run(){
            int i = 0;
            while(i<10){
                i++;
                System.out.println(Thread.currentThread().getName());
            }
            if(Thread.currentThread().getName()=="Thread3"){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while(i<20){
                i++;
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}

class synchronizedMethod{
    Object lock = new Object();
    public void test(){
        int i = 0;
        synchronized (this){
            for (; i < 10; i++) {
                System.out.println("test "+Thread.currentThread().getName()+i);
            }
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void test1(){
        for (int i = 0; i < 10; i++) {
            System.out.println("test1 "+Thread.currentThread().getName()+i);
        }
    }

}