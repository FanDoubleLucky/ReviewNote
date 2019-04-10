package Foundation.DesignPattern;

public class SingletonHunger {
    private static SingletonHunger instance = new SingletonHunger();
    private SingletonHunger(){}
    public static SingletonHunger getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("HelloWorld");
    }
}
