package Foundation.DesignPattern.DecoratorPattern;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape shapeDecorator){
        this.decoratedShape = shapeDecorator;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
