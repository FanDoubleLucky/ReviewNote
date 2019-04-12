package Foundation.DesignPattern.Builder;

public class ChickenBurger extends Burger {
    private String name = "Chicken Burger";
    static float price = 40.0f;

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public float price() {
        return this.price;
    }

    public void setPrice(float price) {
        ChickenBurger.price = price;
    }
}
