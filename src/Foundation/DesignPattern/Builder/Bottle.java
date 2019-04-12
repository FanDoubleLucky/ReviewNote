package Foundation.DesignPattern.Builder;

public class Bottle implements Packing {
    private String packName = "Bottle";
    @Override
    public String pack() {
        return packName;
    }
}
