package Foundation;

public class Equal {

    public static void main(String[] args) {
        IntegerDIY a = new IntegerDIY(10);
        IntegerDIY b = new IntegerDIY(10);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }


}

class IntegerDIY{
    private int val;
    IntegerDIY(int val){
        this.val = val;
    }

    public boolean equals(Object ob){
        return this.val == ((IntegerDIY)ob).val;
    }

    @Override
    public int hashCode() {
        Integer code = val;
        return code.hashCode();
    }
}