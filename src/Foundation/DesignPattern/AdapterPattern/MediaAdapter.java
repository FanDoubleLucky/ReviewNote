package Foundation.DesignPattern.AdapterPattern;

public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer ;
    public MediaAdapter(String audioType){
        if (audioType.equalsIgnoreCase("VLC")){
            advancedMediaPlayer = new VlcPlayer();
        }
        else if (audioType.equalsIgnoreCase("MP4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }


    @Override
    public void play(String audioType, String name) {
        if (audioType.equalsIgnoreCase("VLC")){
            advancedMediaPlayer.playVlc(name);
        }
        else if((audioType.equalsIgnoreCase("Mp4"))){
            advancedMediaPlayer.playMp4(name);
        }
    }
}
