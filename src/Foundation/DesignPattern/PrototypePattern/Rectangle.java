package Foundation.DesignPattern.PrototypePattern;

public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    public void draw(){
        System.out.println("Rectangle::draw() method");
    }
}
