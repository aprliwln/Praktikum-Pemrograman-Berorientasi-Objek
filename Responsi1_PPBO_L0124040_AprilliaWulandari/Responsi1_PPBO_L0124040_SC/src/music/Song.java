package music; //di dalam folder music

public class Song {
    private String title;
    private Artist artist;
    private String duration;

    //constructor
    public Song (String title, Artist artist, String duration) {
        //validasi format durasi menggunakan assertion
        assert duration.matches("\\d{1,2}:\\d{2}") : "Duration must be in mm:ss format";
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    //getter
    public String getTitle() {
        return title;
    }
    public Artist getArtist() {
        return artist;
    }
    public String getDuration() {
        return duration;
    }
}
