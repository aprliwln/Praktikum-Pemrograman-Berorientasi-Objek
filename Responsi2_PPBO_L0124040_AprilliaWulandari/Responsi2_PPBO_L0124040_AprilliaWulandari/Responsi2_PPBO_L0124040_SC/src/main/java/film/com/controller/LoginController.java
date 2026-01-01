package film.com.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
* Controller untuk halaman login aplikasi Cinema Diary.
* <p>
* Kelas ini menangani proses perpindahan tampilan
* dari halaman login ke halaman utama aplikasi.
* </p>
*
* @author aprliwln
*/
public class LoginController {

    /**
    * Dipanggil ketika user menekan tombol login.
    * <p>
    * Method ini akan memuat file {@code main.fxml}
    * dan mengganti scene login dengan scene utama.
    * </p>
    *
    * @param event aksi klik tombol login
    */
    public void login(ActionEvent event) {
        try {
            //load file main.fxml sbg tampilan setelah login
            Parent root = FXMLLoader.load(getClass().getResource("/film/com/view/main.fxml"));
            
            //mengambil stage yg sedang aktif dri event tombol
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root)); //mengganti scene login dgn scene utama
            stage.setTitle("Cinema Diary");
        } catch (Exception e) {
            //jika terjadi kesalahan saat load fxml
            e.printStackTrace();
        }
    }
}
