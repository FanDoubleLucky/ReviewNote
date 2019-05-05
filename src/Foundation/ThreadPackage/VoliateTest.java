package Foundation.ThreadPackage;

//如果stop i都不加volatile i++后面也不加sout，这个程序是不会停的，因为子线程里不会感受到stop的变化，stop从主内存里缓存到cache后就不会再访问主内存的stop
//如果stop不加，i加就可以结束，因为JVM就不会做优化，每次循环都会访问重新访问stop
public class VoliateTest {
    private static volatile boolean stop = false;
    private static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop){
                    i++;
//                    System.out.println("Running");
                }
                System.out.println("Thread: "+i);
            }
        });
        thread.start();
        Thread.sleep(1000);
        stop = true;
        System.out.println(i);
    }
}
