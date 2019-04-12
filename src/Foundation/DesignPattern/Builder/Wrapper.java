package Foundation.DesignPattern.Builder;

/**
 * 实现Packing的包装纸类，用来包装汉堡
 */
public class Wrapper implements Packing {
    private String packName = "Wrapper";
    @Override
    public String pack() {
        return this.packName;
    }
}
