package music;              //di dalam folder music
import java.io.File;        //library utk input output file
import java.util.ArrayList; //library utk struktur data ArrayList
import java.util.Scanner;   //library utk input user


public class Playlist {
    private String name;
    private ArrayList<Song> songs = new ArrayList<>();

    //constructor
    public Playlist (String name) {
        this.name = name;
    }

    //getter
    public String getName() {
        return name;
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }

    //method utk menambah lagu ke playlist
    public void addSong (Song song) {
        songs.add(song);
    }

    //method utk menampilkan isi playlist
    public void displayPlaylist() {
        System.out.println("==============================================================");
        System.out.println("                   Playlist " + name);
        System.out.println("==============================================================");

        //jika playlist kosong
        if (songs.isEmpty()) {
            System.out.println("Empty songs");
            return;
        }
        //jika playlist tidak kosong
        else {
            System.out.printf("%-20s | %-15s | %-10s | %-5s\n", "Title", "Artist", "Genre", "Duration");
            System.out.println("--------------------------------------------------------------");
            for (Song s: songs) {
                System.out.printf("%-20s | %-15s | %-10s | %-5s\n", s.getTitle(), s.getArtist().getName(), s.getArtist().getGenre(), s.getDuration());
            }
        }
        System.out.println("--------------------------------------------------------------");
    }

    //method untuk memuat file
    public void loadFile() {
        try {
            //playlist disimpan di dalam folder "playlists"
            File file = new File("playlists/" + name + ".txt");
            if (!file.exists()) {
                return;
            }

            songs.clear(); //berisihkan daftar lagu

            Scanner sc = new Scanner(file); //input file
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split("\\|");

                //buat object ulang dari file
                Artist a = new Artist(parts[1], parts[2]);
                Song s = new Song(parts[0], a, parts[3]);

                songs.add(s); //tambahkan ke list
            }
            sc.close();
        } catch (Exception e) { //jika gagal memuat file
            System.out.println("Failed load file: " + e.getStackTrace());
        }
    }
}
