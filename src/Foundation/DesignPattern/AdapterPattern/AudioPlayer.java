package Foundation.DesignPattern.AdapterPattern;


public class AudioPlayer implements MediaPlayer {
    public void play(String audioType, String name){
        if(audioType.equalsIgnoreCase("MP3")){
            System.out.println("MP3 Playing: "+name);
        }else if(audioType.equalsIgnoreCase("VLC")||audioType.equalsIgnoreCase("MP4")){
            MediaAdapter ma = new MediaAdapter(audioType);
            ma.play(audioType, name);
        }else{
            System.out.println("Invalid Format");
        }
    }
}
