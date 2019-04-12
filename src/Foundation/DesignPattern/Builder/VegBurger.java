package Foundation.DesignPattern.Builder;

public class VegBurger extends Burger {
    private String name = "Veg Burger";
    static float price = 25.0f;

    public String name(){
        return name;
    }

    @Override
    public float price() {
        return price;
    }

    public void setPrice(float price) {
        VegBurger.price = price;
    }
}
