package Foundation.DesignPattern.Builder;

public class BuilderPatternMain {
    public static void main(String[] args) {
        MealBuilder myTable = new MealBuilder();
        Meal c = myTable.ChickenMeal();
        c.showItems();
        System.out.println(c.price());
    }

}
