package Foundation.DesignPattern.PrototypePattern;

public class PrototypePatternMain {

    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape Id1Clone = ShapeCache.getShape("1");
        Shape Id2Clone = ShapeCache.getShape("2");
        Shape Id3Clone = ShapeCache.getShape("3");
        System.out.println("Id: "+Id1Clone.getId()+" Type: "+Id1Clone.getType());
        System.out.println("Id: "+Id2Clone.getId()+" Type: "+Id2Clone.getType());
        System.out.println("Id: "+Id3Clone.getId()+" Type: "+Id3Clone.getType());
    }
}
