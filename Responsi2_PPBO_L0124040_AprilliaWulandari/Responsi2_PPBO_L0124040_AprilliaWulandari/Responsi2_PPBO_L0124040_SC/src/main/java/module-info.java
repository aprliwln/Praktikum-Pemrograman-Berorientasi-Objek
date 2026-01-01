module film.com {
    //utk komponen UI
    requires javafx.controls;
    //utk memuat file FXML
    requires javafx.fxml;
    //utk rendering grafis JavaFx
    requires transitive javafx.graphics;

    //folder utk FXMLLoader dpt mengakses controller
    opens film.com.controller to javafx.fxml;
    //folder yg dibuka ke JavaFx base dan FXML
    opens film.com.model to javafx.base, javafx.fxml;
    //folder utama
    exports film.com;
}
