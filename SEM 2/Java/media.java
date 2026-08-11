interface Playable{
    void Play();
}
class AudioPlayer implements Playable{
    public void Play(){
        System.out.println("Playing audio...");
    }
}
class VideoPlayer implements Playable{
    public void Play(){
        System.out.println("Playing video...");
    }
}
class media{
    public static void main(String[] args) {
        Playable audioPlayer = new AudioPlayer();
        Playable videoPlayer = new VideoPlayer();

        audioPlayer.Play();
        videoPlayer.Play();
    }
}