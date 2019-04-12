package Foundation.DesignPattern.Builder;

public abstract class Burger implements FoodItem{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
