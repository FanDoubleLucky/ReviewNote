package Foundation.DesignPattern.Builder;

public class MealBuilder {
    public Meal VegerMeal(){
        Meal vegM =  new Meal();
        vegM.addItem(new VegBurger());
        vegM.addItem(new Coke());
        return vegM;
    }

    public Meal ChickenMeal(){
        Meal chickenM = new Meal();
        chickenM.addItem(new ChickenBurger());
        chickenM.addItem(new Pepsi());
        return chickenM;
    }
}
