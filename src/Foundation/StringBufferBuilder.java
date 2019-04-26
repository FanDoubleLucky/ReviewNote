package Foundation;

/**
 * StringBuffer StringBuilder都是实现的CharSeqence接口
 * 它们方法一样 append capacity delete deleteCharAt insert charAt
 */
public class StringBufferBuilder {
    public static void main(String[] args) {
        StringBuffer sbf = new StringBuffer();//StringBuffer是线程安全的
        sbf.append("www.");
        sbf.append("bupt.");
        sbf.append("edu.cn");

        System.out.println(sbf.toString());
        System.out.println(sbf.charAt(8));
        sbf.delete(8, 9);
        sbf.deleteCharAt(8);


        System.out.println(sbf);
        sbf.insert(8, 'T');
        System.out.println(sbf);
        System.out.println(sbf.capacity());

        StringBuilder sbd = new StringBuilder();//StringBuilder不是线程安全的
        sbd.append("www.");
        sbd.append("baidu.");
        sbd.append(1);
        sbd.append("com");
        sbd.delete(8, 9);
        sbd.deleteCharAt(8);
        sbd.insert(8,'T');
        sbd.capacity();
        sbd = new StringBuilder("www.baidu.com");
        sbf = new StringBuffer("www.baidu.com");
        System.out.println(sbf.equals(sbd));//F，不同类

    }
}
