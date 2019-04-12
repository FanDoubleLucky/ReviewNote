package Foundation.DesignPattern.Builder;

public class Pepsi extends ColdDrink{
    private String name = "Pepsi";
    static float price = 15.0f;

    public String name(){
        return this.name;
    }

    @Override
    public float price() {
        return Coke.price;
    }

    public static void setPrice(float price) {
        Coke.price = price;
    }
}
