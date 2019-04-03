package Foundation;

public class RetrieveCPro {

    public native int ImageShow(String imageName);

    static {
        System.load("/Users/fyz/IdeaProjects/ReviewNote/test.jnilib");
    }

    public static void main(String[] args) {
        int out = new RetrieveCPro().ImageShow("/Users/fyz/Desktop/CR.jpg");
        System.out.println(out);
    }
}


