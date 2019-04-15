package Foundation.DesignPattern.AdapterPattern;

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String name) {
        System.out.println("Palying MP4 audio "+name);
    }

    @Override
    public void playVlc(String name) {
    }
}