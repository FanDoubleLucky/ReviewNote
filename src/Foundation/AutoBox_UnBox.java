package Foundation;

public class AutoBox_UnBox {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Integer F = 642;
        Long g = 3l;
        System.out.println(c ==d);//F   T,因为c和d的数值小于128
        System.out.println(e==f);//F
        System.out.println(c==(a+b));//T
        System.out.println(F==(e+f));//T
        System.out.println(c.equals(a+b));//T
        System.out.println(g==(a+b));//T
        System.out.println(g.equals(a+b));//T  F

        Integer H = a+b;
        int h = a+b;
        System.out.println(g.equals(H));//F
        System.out.println(g.equals(h));//F
        System.out.println(H.equals(h));//T

        // 自动拆箱引起的NPE
        InnerClass ic = new InnerClass();
        ic.getValue();//NPE

    }

    static class InnerClass{
        private Integer value;
        private int getValue(){
            return value;//NPE的源头，因为return的int，所以return value; -> return value.intValue();
        }
    }
}
