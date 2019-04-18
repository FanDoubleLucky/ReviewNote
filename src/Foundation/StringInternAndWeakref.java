package Foundation;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;

public class StringInternAndWeakref {
    public static void main(String[] args){
        String A = "kill";
        String B = new String("kill");
        System.out.println(A==B);
        System.out.println(A.equals(B));
        System.out.println(A==B.intern());
        System.out.println(A==B);
        B=B.intern();
        System.out.println(A==B);
        Integer num = new Integer(999);
        WeakReference AW = new WeakReference(num);
        WeakReference BW = new WeakReference(new Integer(999));
        WeakReference CW = new WeakReference("Although Weak but won't GC as I am in String Pool hahahaha");
        WeakReference DW = new WeakReference(new String("Although I am String but not in String Pool will be GC"));
        System.out.println(AW.get());
        System.out.println(BW.get());
        System.out.println(CW.get());
        System.out.println(DW.get());
        System.gc();
        System.out.println(AW.get());//AW不会被GC回收，因为构造函数里的参数不是new的而是引用，num这个引用没有死，所以这个对象不会被GC
        System.out.println(BW.get());//会被GC
        System.out.println(CW.get());
        System.out.println(DW.get());

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
//        s3.intern();
        System.out.println(s3==s4);
    }
}
