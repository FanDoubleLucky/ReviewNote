package Foundation;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ClassLoaderTest {
    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);//创建输入class文件的输入流
                    if(is==null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];//创建存储class字节码的byte空间
                    is.read(b);//读class的字节码
                    return defineClass(name, b, 0, b.length);//根据读进来的class字节码定义class，创建的是一个java.lang.Class对象
                }
                catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };
        ClassLoader c = ClassLoader.getSystemClassLoader();//获得Application ClassLoader加载器
        System.out.println(c.loadClass("java.lang.Object").newInstance().getClass());
        Class myclass = myLoader.loadClass("Foundation.ClassLoaderTest");
        Object ob = myclass.newInstance();
        System.out.println(ob.getClass().getName());
        System.out.println(ob instanceof Foundation.ClassLoaderTest);//fasle，因为ob是自己定义的加载器加载的，而Foundation.ClassLoaderTest是JVM内置的加载器加载的
    }
}
