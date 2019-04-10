package Foundation.DesignPattern;

public class SingletonLazy {
    private static SingletonLazy instance;
    private SingletonLazy(){}
    public SingletonLazy getInstance(){
        if(instance==null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
