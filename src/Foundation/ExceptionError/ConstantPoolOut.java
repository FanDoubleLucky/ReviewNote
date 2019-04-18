package Foundation.ExceptionError;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *  这个程序1.7以后就不会报错了，因为intern变了，不再往常量池里复制
 */
public class ConstantPoolOut {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        int i =0;
        while (true){
            a.add(String.valueOf(i++).intern());
        }
    }
}
