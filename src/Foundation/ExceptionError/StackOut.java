package Foundation.ExceptionError;


/**
 * VM Args: -Xss128k
 */
public class StackOut {

    public static void main(String[] args) {
        stackLeak();
    }
    static void stackLeak(){
        stackLeak();
    }

}
