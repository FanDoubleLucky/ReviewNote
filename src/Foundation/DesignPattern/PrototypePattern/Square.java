package Foundation.DesignPattern.PrototypePattern;

public class Square extends Shape {

    public Square(){
        this.type = "Square";
    }

    public void draw(){
        System.out.println("Square::draw() method");
    }
}
