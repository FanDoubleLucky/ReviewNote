package Foundation.ExceptionError;

import java.util.ArrayList;

/**
 *VM Args: -Xms20m -Xmx20m  先配置VM heap的大小
 */
public class HeapOut {
    static class HeapOOM{

    }

    public static void main(String[] args) {
        ArrayList<HeapOOM> a = new ArrayList<>();
        while (true){
            a.add(new HeapOOM());
        }
    }
}
