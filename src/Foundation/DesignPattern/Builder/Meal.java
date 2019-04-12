package Foundation.DesignPattern.Builder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<FoodItem> items= new ArrayList<FoodItem>();

    public void addItem(FoodItem item){
        this.items.add(item);
    }

    public float price(){
        float price = 0.0f;
        for (FoodItem item :
                items) {
            price+=item.price();
        }
        return price;
    }

    public void showItems(){
        for (FoodItem item :
                items) {
            System.out.println(item.name());
            System.out.println(item.packing().pack());
            System.out.println(item.price());
        }
    }

}
