package Foundation.DesignPattern;

public class DesignPatternMain {
    public static void main(String[] args) {
        //单例模式调用
        SingletonHunger object = SingletonHunger.getInstance();
        object.showMessage();


        //工厂模式调用
        ShapeFactory sf = new ShapeFactory();
        Shape shape = sf.getShape("Circle");
        shape.draw();
    }
}
