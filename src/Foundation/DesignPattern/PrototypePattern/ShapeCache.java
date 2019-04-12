package Foundation.DesignPattern.PrototypePattern;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap= new Hashtable<String, Shape>();

    /**
     * 根据数据库数据的id查找这个对应的shape
     * @param shapeId
     * @return
     */
    public static Shape getShape(String shapeId){
         Shape cache = shapeMap.get(shapeId);
         return (Shape) cache.clone();
    }

    /**
     * loadCache是数据库缓存查询结果的过程，id 1 2 3是之前的查询条件Circle, Square, Rectangle三个查询得到的对象，缓存在shapeMap
     */
    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
