package Foundation.DesignPattern.Builder;

public class Coke extends ColdDrink{
    private String name = "ColdDrink";
    static float price = 10.0f;

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
