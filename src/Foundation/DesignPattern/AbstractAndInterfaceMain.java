package Foundation.DesignPattern;

public class AbstractAndInterfaceMain {
    public static void main(String[] args) {
        AbstractClass ac = new AbstractClass() {
            @Override
            public int getId() {
                return super.getId();
            }
        };
        System.out.println(ac.getName());
        Car myCar = new Benz();
    }
}
