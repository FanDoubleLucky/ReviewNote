package Foundation.DesignPattern.PrototypePattern;

public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    public void draw(){
        System.out.println("Circle::draw() method");
    }
}
