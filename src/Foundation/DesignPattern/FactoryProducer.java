package Foundation.DesignPattern;

public class FactoryProducer {
    public AbstactFactory getFactory(String factoryType){
        if(factoryType.equalsIgnoreCase("Shape")){
            return new ShapeFactory();
        }
        else if(factoryType.equalsIgnoreCase("Color")){
            return new ColorFactory();
        }
        return null;
    }
}
