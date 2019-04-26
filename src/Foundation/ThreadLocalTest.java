package Foundation;

public class ThreadLocalTest {
    //直接生成对象
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    //直接生成对象并且定义get的初始化值
    private ThreadLocal tl_gen_init = new ThreadLocal<String>(){
        /**
         * ThreadLocal对象调用get方法时最后return setInitialValue()，而setInitialValue的开头是initialValue()
         * @return
         */
        @Override
        protected String initialValue() {
            return "Set a initial value";
        }
    };

    public static void main(String[] args) {
        ThreadLocalTest myTest = new ThreadLocalTest();

        myTest.threadLocal.set("Th");
        String s = myTest.threadLocal.get();

        System.out.println(myTest.tl_gen_init.get());
        myTest.tl_gen_init.set("Update Value");
        System.out.println(myTest.tl_gen_init.get());

        Thread t1 = new Thread(new ThreadRun(),"T1");
        Thread t2 = new Thread(new ThreadRun(),"T2");

        t1.start();
        t2.start();
    }

    static class ThreadRun implements Runnable{
        public void run(){
            while(true) {
                threadLocal.set(Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            }
        }
    }
}
