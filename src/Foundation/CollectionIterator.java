package Foundation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CollectionIterator {

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            res.add(i);
        }
        //这个例子告诉我们每次循环判断size会变的，如果不加i<20，这个循环会一直进行下去
        for (int i = 0; i < res.size()&&i<20; i++) {
            System.out.println(res.get(i));
            res.add(10+i);
        }
    }
}
