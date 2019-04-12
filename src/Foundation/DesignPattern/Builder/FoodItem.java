package Foundation.DesignPattern.Builder;

/**
 * 食物原始接口
 */
public interface FoodItem {
    public String name();
    public Packing packing();
    public float price();
}
