package Foundation.DesignPattern;

public class ColorFactory extends AbstactFactory {

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("YELLOW")){
            return new Yellow();
        }
        return null;
    }

    @Override
    public Shape getShape(String type) {
        return null;
    }
}
