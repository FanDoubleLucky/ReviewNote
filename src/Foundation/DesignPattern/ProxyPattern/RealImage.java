package Foundation.DesignPattern.ProxyPattern;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;

public class RealImage implements Image {
    private String fileName;
    private ArrayList<Integer> data;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Image Display");
    }

    public void loadFromDisk(String fileName){
        /**
         * 读取图片
         */
        System.out.println("Loaded Picture "+fileName);
    }

}
