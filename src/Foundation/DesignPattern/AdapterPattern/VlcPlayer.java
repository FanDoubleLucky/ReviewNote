package Foundation.DesignPattern.AdapterPattern;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String name) {

    }

    @Override
    public void playVlc(String name) {
        System.out.println("Palying VLC audio "+name);
    }
}
