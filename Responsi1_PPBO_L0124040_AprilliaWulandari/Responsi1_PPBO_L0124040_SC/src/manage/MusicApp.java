package manage; //di dalam folder manage
import music.*; //import folder music

import java.io.File;        //library utk input output file
import java.io.FileWriter;  //library utk menulis ke file
import java.util.ArrayList; //library utk struktur data ArrayList
import java.util.Scanner;   //library utk input user

public class MusicApp {
    private ArrayList<Song> listSongs = new ArrayList<>();
    private ArrayList<Artist> listArtists = new ArrayList<>();

    //menambahkan artis ke list
    public void addArtist (Artist a) {
        listArtists.add(a);
    }
    //menambahkan lagu ke list
    public void addSong (Song s) {
        listSongs.add(s);
    }
    //getter
    public ArrayList<Song> getAllSongs() {
        return listSongs;
    }

    //mencari judul lagu berdasarkan judul
    public Song searchByTitle (String title) throws Exception {
        //memastikan input judul tidak kosong
        assert title != null && !title.trim().isEmpty(): "Ttile cannot be empty";
        //perulangan untuk mencari judul yg sesuai
        for (Song s: listSongs) {
            //jika terdapat judul yang sama
            if (s.getTitle().equalsIgnoreCase(title)) {
                return s; //mengembalikan lagu
            }
        }
        //jika tidak ditemukan judul yang sama
        throw new Exception("Not found the song");
    }

    //menampilkan semua daftar lagu
    public void listAllSongs() {
        System.out.println("==============================================================");
        System.out.println("                        LIST ALL SONGS                        ");
        System.out.println("==============================================================");  

        //jika daftar lagu kosong
        if (listSongs.isEmpty()) {
            System.out.println("Empty song");
            return;
        }
        //jika terdapat lagu
        else {
            System.out.printf("%-20s | %-15s | %-10s | %-5s\n", "Title", "Artist", "Genre", "Duration");
            System.out.println("--------------------------------------------------------------");
            for (Song s: listSongs) {
                System.out.printf("%-20s | %-15s | %-10s | %-5s\n", s.getTitle(), s.getArtist().getName(), s.getArtist().getGenre(), s.getDuration());
            }
        }
        System.out.println("--------------------------------------------------------------");
    }

    //menampilkan semua daftar lagu secara terurut (dari A - Z)
    public void listSongsSorted() {
        //melakukan sorting dgn membandingkan huruf pertama dri judul lagu
        listSongs.sort((a,b) -> {
            //mengambil huruf pertama
            char c1 = a.getTitle().toUpperCase().charAt(0);
            char c2 = b.getTitle().toUpperCase().charAt(0);
            //membandingkan dua karakter utk mengurutkan
            return Character.compare(c1, c2); 
        });
        listAllSongs();
    }

    //menyimpan seluruh lagu ke file ListSongs.txt
    public void saveAllSongs() {
        try {
            FileWriter writer = new FileWriter("ListSongs.txt");
            //perulangan utk ditulis di dalam file
            for (Song s: listSongs) {
                writer.write(s.getTitle() + "|"
                            + s.getArtist().getName() + "|"
                            + s.getArtist().getGenre() + "|"
                            + s.getDuration() + "\n");  
            }
            writer.close();
        } catch (Exception e) { //jika gagal menyimpan lagu
            System.out.println("Failed to save file: " + e.getStackTrace());
        }
    }

    //method untuk memuat seluruh lagu dari ListSongs.txt
    public void loadSongs() {
        try {
            File file = new File("ListSongs.txt");
            //jika file tidak ditemukan
            if (!file.exists()) {
                return;
            }

            Scanner sc = new Scanner(file); //input file
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split("\\|");

                //buat object ulang dari file
                Artist a = new Artist(parts[1], parts[2]);
                Song s = new Song(parts[0], a, parts[3]); 

                //tambahkan ke dalam list
                addArtist(a);
                addSong(s);
            }
            sc.close();
        } catch (Exception e) { //jika gagal memuat file
            System.out.println("Failed to load file: " + e.getStackTrace());
        }
    }
}
