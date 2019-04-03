package Foundation;

import com.sun.tools.internal.xjc.reader.RawTypeSet;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Generic {

    public static void main(String[] args) {
        ArrayList<String> Ss = new ArrayList<String>();
        Ss.add("1st");
        ArrayList<Integer> Is = new ArrayList<Integer>();
        Is.add(999);
        Is.add(666);
        System.out.println(Ss.getClass()==Is.getClass());//因为泛型擦除，所以全都成了java.util.ArrayList

        for (int i = 0; i < Ss.size(); i++) {
            System.out.println(Ss.get(i).getClass().getName());//List里的元素类型都被擦成了Object，但是直接看是看不到的，因为get方法返回的类型都转成了泛型参数类型
        }

        //直接看看不到，但是可以通过反射机制看到
        Class Sscalss = Ss.getClass();
        Field[] fs = Sscalss.getDeclaredFields();
        Method[] ms = Sscalss.getDeclaredMethods();
        for (Field f:
             fs) {
            System.out.println(f.getName()+" getType: "+f.getType().getName());//此处众多成员变量中可以看到ArrayList的elementData，并且返回的类型不是String而是Object，说明已经类型被擦除
        }
        for (Method m :
                ms) {
            System.out.println(m.getName()+" getBackType: "+m.getReturnType().getName());
        }

        //利用类型擦除，都被擦成了Object这个特征，再借助反射机制，可以绕过编译器报错，向ArrayList中加入各种类型的元素，以下例子就是向ArrayList<String>中加float
        //Ss.add(45.7f);编译器报错
        try {
            Method addM = Sscalss.getDeclaredMethod("add", Object.class);

            addM.invoke(Ss, 45.7f);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Ss.size(); i++) {
            System.out.println((Object) Ss.get(i));
        }

        //这是一个Raw Type的例子，new ArrayList()的时候没有指定任何数据类型，与new ArrayList<Object>()不同，这个是指定了Object类型
        List raw = new ArrayList();

        raw.add(12);
        raw.add("op");
        raw.add(false);
        for (Object o :
                raw) {
            System.out.println(o.toString());
        }


        //通配符的示例 <?> <? extends> <? super>三种
        ArrayList<Number> Ns = new ArrayList<Number>();
        ArrayList<Double> Ds = new ArrayList<Double>();
        Ds.add(56d);
        Ds.add(89d);
        ListTransWildCardExtendsNumber(Is);
        ListTransWildCardExtendsNumber(Ds);
//        ListTransWildCardExtendsInteger(Ns); 报错，因为Ns中是Number不是Integer的子类
        ListTransWildCard(Is);
        ListTransWildCard(Ss);
        ListTransWildCard(Ns);
        ListTransWildCardSuper(Is);
//        ListTransWildCardSuper(Ss);报错，String不是Integer父类
        ListTransWildCardSuper(Ns);//可以，因为Number是Integer的父类
    }


    //List中的Class必须是Number的子类，限制了？的上界
    public static void ListTransWildCardExtendsNumber(List<? extends Number> list){
        for (Object o:
             list) {
            System.out.println(o);
        }

//        list.add(new Integer(777));  ERROR <? extends XXX>不允许add，因为？是XXX的子类，此处add相当于SubClass s=new SuperClass(), ？可能是Integer可能是Double，不能向List<Int>中加Number

        return;
    }


    public static void ListTransWildCardExtendsInteger(List<? extends Integer> list){
        for (Object o:
                list) {
            System.out.println(o);
        }

//        list.add(new Integer(777)); ERROR

        return;
    }



    public static void ListTransWildCard(List<?> list){
        for (Object o:
                list) {
            System.out.println(o);
        }

//        list.add(new Object()); Error

        return;
    }

    //List中的Class必须是Integer的父类，限制了？的下界
    public static void ListTransWildCardSuper(List<? super Integer> list){
        for (Object o:
                list) {
            System.out.println(o);
        }

        list.add(new Integer(777)); //<? super XXX>中允许add，因为？是XXX的父类，此处add相当于SuperClass s=new SubClass(), 比如List<Number>中加Integer，这是合法的

        return;
    }
}
