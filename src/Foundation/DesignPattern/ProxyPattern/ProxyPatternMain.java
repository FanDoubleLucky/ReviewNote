package Foundation.DesignPattern.ProxyPattern;

public class ProxyPatternMain {
    public static void main(String[] args) {
        Image image = new ProxyImage("/static/web-inf/picture.jpg");
        image.display();
    }
}
