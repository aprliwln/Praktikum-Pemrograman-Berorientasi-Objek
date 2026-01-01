package manage; //di dalam folder manage
import music.*; //import folder music

import java.io.File;        //library utk input output file
import java.io.FileWriter;  //library utk menulis ke file
import java.util.ArrayList; //library utk struktur data ArrayList
import java.util.Scanner;   //library utk input user

public class PlaylistManage {
    private MusicApp app = new MusicApp();
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    //constructor
    public PlaylistManage() {
        app.loadSongs(); //memuat daftar lagu
        loadPlaylists(); //memuat daftar playlist
    }

    //menu utama
    public void menu() {
        while (true) {
            System.out.println("====================================");
            System.out.println("           MELODY CRAFT             ");
            System.out.println("====================================");
            System.out.println("       [1] Add A Song               ");
            System.out.println("       [2] List All Songs           ");
            System.out.println("       [3] List All Songs Sorted    ");
            System.out.println("       [4] Make A Playlist          ");
            System.out.println("       [5] Add A Song Playlist      ");
            System.out.println("       [6] See Playlist             ");
            System.out.println("       [7] Search Song              ");
            System.out.println("       [8] Exit                     ");
            System.out.println("------------------------------------");
            System.out.print("Input option: ");
            int option = sc.nextInt();
            sc.nextLine(); //membuang newline

            switch (option) {
                case 1:
                    addSong();
                    break;
                case 2:
                    app.listAllSongs();
                    break;
                case 3:
                    app.listSongsSorted();
                    break;
                case 4:
                    createPlaylist();
                    break;
                case 5:
                    addSongPlaylist();
                    break;
                case 6:
                    seePlaylist();
                    break;
                case 7:
                    findSong();
                    break;
                case 8:
                    System.out.println("Thank you for trying this program");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    //method utk menyimpan playlist ke file
    public void savePlaylist (Playlist p) {
        try {
            //memastikan jika folder playlists ada
            File folder = new File("playlists");
            //jika belum ada maka akan dibuat
            if (!folder.exists()) {
                folder.mkdir();
            }

            //menulis ulang file playlistnya
            FileWriter writer = new FileWriter("playlists/" + p.getName() + ".txt");
            //loop semua lagu dalam playlist
            for (Song s: p.getSongs()) {
                writer.write(s.getTitle() + "|"
                            + s.getArtist().getName() + "|"
                            + s.getArtist().getGenre() + "|"
                            + s.getDuration() + "\n");
            }
            writer.close();
        } catch (Exception e) { //jika gagal menyimpan playlist
            System.out.println("Failed to save playlists: " + e.getMessage());
        }
    }

    //method untuk menambahkan lagu baru
    public void addSong() {
        System.out.println("------------------------------------");
        System.out.print("Title\t: ");
        String title = sc.nextLine();

        System.out.print("Artist\t: ");
        String artist = sc.nextLine();

        System.out.print("Genre\t: ");
        String genre = sc.nextLine();

        System.out.print("Duration (mm:ss): ");
        String duration = sc.nextLine();
        System.out.println("------------------------------------");

        //buat objek baru artist dan song
        Artist a = new Artist(artist, genre);
        Song s = new Song(title, a, duration);
        
        //tambahkan ke list song
        app.addArtist(a);
        app.addSong(s);
        //simpan semua lagu ke dalam file
        app.saveAllSongs();

        System.out.println("Song added successfully");
    }

    //membuat playlist baru
    public void createPlaylist() {
        System.out.println("------------------------------------");
        System.out.print("Playlist name: ");
        String name = sc.nextLine();

        //validasi jika nama playlist kosong
        if (name.isEmpty()) {
            System.out.println("Playlist name cannot be empty");
            return;
        }

        //mengecek apakah playlist dengan nama yang sama sudah ada
        for (Playlist p: playlists) {
            //jika nama sudah ada
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("Playlist alredy exists");
                return;
            }
        }

        //jika belum, buat playlist baru
        Playlist p = new Playlist(name);
        playlists.add(p);
        //simpan playlist kosongnya
        savePlaylist(p);
        System.out.println("Playlist created successfully (empty)");
    }

    //menambahkan lagu ke playlist
    public void addSongPlaylist() {
        System.out.println("------------------------------------");
        //jika tidak ada playlist
        if (playlists.isEmpty()) {
            System.out.println("No playlist available");
            return;
        }
        //tampilkan list playlist yg ada
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + playlists.get(i).getName());
        }
        System.out.println("------------------------------------");
        
        System.out.print("Choose playlist: ");
        int option = sc.nextInt() - 1;
        sc.nextLine();
        //cek validasi
        if (option < 0 || option >= playlists.size()) {
            System.out.println("Invalid playlist number");
            return;
        }

        Playlist select = playlists.get(option); //object
        //load isi file playlist ke memori
        select.loadFile();
        //list semua lagu yg ada
        app.listAllSongs();
        //input judul lagu yg ingin ditambahkan
        System.out.print("Input song title: ");
        String title = sc.nextLine();
        try {
            //cari lagu berdasarkan judul
            Song chosen = app.searchByTitle(title);

            //tambahkan ke playlist
            select.addSong(chosen);
            //simpan ulang file playlist
            savePlaylist(select);
            System.out.println("Song added to playlist successfully");
        } catch (Exception e) { //jika lagu tidak ditemukan
            System.out.println("Song not found");
        }
    }

    //method utk mencari judul lagu
    public void findSong() {
        System.out.println("------------------------------------");
        System.out.print("Title: ");
        String title = sc.nextLine();
        try {
            System.out.println("------------------------------------");
            //cari musik
            Song found = app.searchByTitle(title);
            //menampilkan info lengkap
            System.out.println("Title\t: " + found.getTitle());
            System.out.println("Artist\t: " + found.getArtist().getName());
            System.out.println("Genre\t: " + found.getArtist().getGenre());
            System.out.println("Duration: " + found.getDuration());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //menampilkan lagu yang ada di dalam playlist
    public void seePlaylist() {
        System.out.println("------------------------------------");
        //jika tidak ada playlist
        if (playlists.isEmpty()) {
            System.out.println("No playlist available");
            return;
        }

        //list semua playlist
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + playlists.get(i).getName());
        }
        System.out.println("------------------------------------");
        
        System.out.print("Choose Playlist: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        //cek validasi
        if (index < 0 || index >= playlists.size()) {
            System.out.println("Invalid playlist number");
            return;
        }

        Playlist playlist = playlists.get(index); //object
        playlist.loadFile();        //muat lagi yang ada di dalam playlist tersebut
        playlist.displayPlaylist(); //menampilka isi playlistnya
    }

    //memuat semua playlist dari folder playlists
    public void loadPlaylists() {
        playlists.clear(); //berishkan daftar playlists

        File folder = new File("playlists");
        //jika folder tidak ada (blm ada playlists)
        if (!folder.exists()) {
            return;
        }

        //mengambil semua file .txt dalam folder playlists
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null) {
            return;
        }
        //tiap file = 1 playlist
        for (File f: files) {
            String fileName = f.getName().replace(".txt", "");
            playlists.add(new Playlist(fileName));
        }
    }
}
