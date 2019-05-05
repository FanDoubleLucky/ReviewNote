package Foundation;

import java.io.*;
import java.util.*;

public class SerializableMain {
    public static void main(String[] args) {
        SerializableObject so = new SerializableObject("Em");
        so.setAddress("192.168.1.1");
        try {
            FileOutputStream fileOut = new FileOutputStream("Object.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(so);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileIn = new FileInputStream("Object.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            SerializableObject ob = (SerializableObject)in.readObject();//此处即使没有在代码上类型转换成SerializableObject，但是还是会有类加载过程，还是可以抛出ClassNotFound
            System.out.println(ob.getAddress());
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
