package film.com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
* Kelas {@code Responsi2_PPBO_L0124040_SC} merupakan
* kelas utama (entry point) aplikasi Cinema Diary.
* <p>
* Kelas ini mewarisi {@link Application} dari JavaFX
* dan bertugas untuk:
* </p>
* <ul>
*   <li>Menjalankan lifecycle JavaFX</li>
*   <li>Memuat tampilan awal (login)</li>
*   <li>Menampilkan window utama aplikasi</li>
* </ul>
*
* @author aprliwln
*/
public class Responsi2_PPBO_L0124040_SC extends Application {

    /**
    * Method {@code start} dipanggil secara otomatis
    * oleh JavaFX saat aplikasi dijalankan.
    * <p>
    * Method ini memuat file {@code login.fxml}
    * sebagai tampilan awal aplikasi.
    * </p>
    *
    * @param stage stage utama aplikasi
    * @throws Exception jika terjadi kesalahan
    *         saat memuat file FXML
    */
    @Override
    public void start(Stage stage) throws Exception {
        //memuat layout login dari file FXML
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/film/com/view/login.fxml")
        );
        //set scene menggunakan layout yg dimuat
        stage.setScene(new Scene(loader.load()));
        //set judul aplikasi
        stage.setTitle("Login");
        //menampilkan jendela utama
        stage.show();
    }

    /**
    * Method {@code main} berfungsi sebagai
    * titik awal eksekusi aplikasi Java.
    * <p>
    * Method ini akan memanggil lifecycle JavaFX
    * melalui method {@code Application.launch()}.
    * </p>
    *
    * @param args argumen command-line
    */
    public static void main(String[] args) {
        launch(); //memanggil lifecycle javafx
    }
}
