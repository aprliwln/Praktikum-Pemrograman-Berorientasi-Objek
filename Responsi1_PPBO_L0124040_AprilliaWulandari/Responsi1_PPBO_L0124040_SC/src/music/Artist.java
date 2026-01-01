package music; //di dalam folder music

public class Artist {
    private String name;
    private String genre;

    //constructor
    public Artist (String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    //getter
    public String getName() {
        return name;
    }
    public String getGenre() {
        return genre;
    }
}
