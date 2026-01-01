package film.com.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javafx.application.Platform;

/**
* Kelas {@code MediaStorage} bertugas
* untuk menyimpan dan memuat data media
* ke dalam file teks.
* <p>
* Proses I/O dilakukan secara asynchronous
* agar tidak mengganggu UI JavaFX.
* </p>
*
* @author aprliwln
*/
public class MediaStorage {
    /**Nama file penyimpanan data */
    private static final String FILE_NAME = "media_data.txt";

    /**
    * Menyimpan data media secara asynchronous.
    *
    * @param list daftar media
    */
    public static void saveAsync(List<CinemaItem> list) {
        new Thread(() -> save(list)).start();
    }

    /**
    * Memuat data media secara asynchronous.
    *
    * @param callback fungsi callback untuk update UI
    */
    public static void loadAsync(Consumer<List<CinemaItem>> callback) {
        new Thread(() -> {
            List<CinemaItem> data = load(); //load data scr sinkron
            Platform.runLater(() -> callback.accept(data)); //update UI di JavaFx thread
        }).start();
    }

    /**
    * Menyimpan data media secara sinkron.
    *
    * @param list daftar media
    */
    public static void save(List<CinemaItem> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (CinemaItem m : list) {
                boolean marked = false;
                if (m instanceof Marked mk) {
                    marked = mk.isMarked(); //ambil status marked jika ada
                }
                pw.println(
                        m.getType() + "|" +
                        m.getTitle() + "|" +
                        m.getRating() + "|" +
                        m.getDescription() + "|" +
                        m.getGenre() + "|" +
                        marked
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Memuat data media dari file.
    *
    * @return list media
    */
    public static List<CinemaItem> load() {
        List<CinemaItem> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        //jika file tdk ada, kembalikan list kosong
        if (!file.exists()) return list;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                String type = data[0];
                String title = data[1];
                double rating = Double.parseDouble(data[2]);
                String desc = data[3];
                String genr = data[4];
                boolean marked = data.length > 5 && Boolean.parseBoolean(data[5]);

                //memuat objek film berdasarkan tipe
                CinemaItem item = switch (type) {
                    case "Movie" -> new Movie(title, rating, desc, genr);
                    case "Series" -> new Series(title, rating, desc, genr);
                    default -> null;
                };

                //set status marked jika implementasi Marked
                if (item instanceof Marked m) {
                    m.setMark(marked);
                }

                if (item != null) list.add(item); //tambahkan ke list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list; //kembalikan list media
    }
}
