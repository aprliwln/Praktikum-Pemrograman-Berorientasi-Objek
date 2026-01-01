package film.com.controller;

import film.com.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

/**
* Controller utama aplikasi Cinema Diary.
* <p>
* Mengelola input data film/series, filtering,
* pencarian, penandaan, serta interaksi TableView.
* </p>
*
* @author aprliwln
*/
public class MainController {
    /**Komponen Form Input */
    @FXML private TextField titleField;
    @FXML private ComboBox<String> typeBox;
    @FXML private ComboBox<String> genreBox;
    @FXML private TextField ratingField;
    @FXML private TextField searchField;
    @FXML private TextArea descArea;
    /**Komponen Table View */
    @FXML private TableView<CinemaItem> tableView;
    @FXML private TableColumn<CinemaItem, String> titleCol;
    @FXML private TableColumn<CinemaItem, String> typeCol;
    @FXML private TableColumn<CinemaItem, String> genreCol;
    @FXML private TableColumn<CinemaItem, Double> ratingCol;
    @FXML private TableColumn<CinemaItem, String> descCol;
    @FXML private TableColumn<CinemaItem, String> markedCol;
    /**Menyimpan seluruh data media */
    private List<CinemaItem> cinemaList = new ArrayList<>();

    /**
    * Dipanggil otomatis saat FXML dimuat.
    * <p>
    * Method ini mengatur:
    * </p>
    * <ul>
    *   <li>Isi ComboBox</li>
    *   <li>Koneksi TableColumn</li>
    *   <li>Tooltip deskripsi</li>
    *   <li>Load data async</li>
    *   <li>Pencarian realtime</li>
    * </ul>
    */
    public void initialize() {
        //pilihan tipe film
        typeBox.getItems().addAll("Movie", "Series");
        //pilihan genre
        genreBox.getItems().addAll("Action", "Fantasy", 
                "Romance", "Sci-Fi", "Horror", "Family", "Thriller");

        //menghubungkan kolom tabel dgn properti media item
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        //mengatur lebar kolom deskripsi
        descCol.setMaxWidth(Double.MAX_VALUE); // Membuang batasan lebar maksimal
        tableView.widthProperty().addListener((obs, oldVal, newVal) -> {
            double totalWidth = newVal.doubleValue();
            double otherColsWidth = titleCol.getWidth() + typeCol.getWidth() + 
                                    genreCol.getWidth() + ratingCol.getWidth() + 
                                    markedCol.getWidth();
            //sisa ruang
            double buffer = 25; 
            descCol.setPrefWidth(totalWidth - otherColsWidth - buffer);
        });

        //utk deskripsi yg panjang, ketika kursor diarahkan ke teks, maka seluruh teks akan terlihat
        descCol.setCellFactory(column -> new TableCell<CinemaItem, String>() {
            private final Tooltip tooltip = new Tooltip();
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setTooltip(null);
                } else {
                    setText(item);
                    tooltip.setText(item);
                    
                    tooltip.setPrefWidth(250); 
                    tooltip.setWrapText(true);
                    setTooltip(tooltip);
                }
            }
        });
        
        //menampilkan status pada film
        markedCol.setCellValueFactory(cellData -> {
            CinemaItem item = cellData.getValue();
            if (item instanceof Marked m) {
                return new SimpleStringProperty(m.isMarked() ? "Done" : "Undone"); //markable
            } else {
                return new SimpleStringProperty("N/A"); //kalau tidak markable
            }
        });

        //mengatur teks default tipe film
        typeBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "Select Type" : item);
            }
        });

        //mengatur teks default genre
        genreBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "Select Genre" : item);
            }
        });

        //load data dari file scr asinkron (multithreading)
        MediaStorage.loadAsync(data -> {
            cinemaList = data; //simpan ke list utama
            tableView.getItems().setAll(cinemaList); //tampilkan ke tabel
        });

        //untuk pencarian realtime
        searchField.textProperty().addListener((obs, o, n) -> searchCinema());
    }

    /**Menampilkan semua data ke tabel*/
    @FXML
    public void showAll() {
        tableView.getItems().setAll(cinemaList);
    }
    /**Filter hanya Movie */
    @FXML
    public void filterMovie() {
        filterByType("Movie");
    }
    /**Filter hanya series */
    @FXML
    public void filterSeries() {
        filterByType("Series");
    }
    /**Filter berdasarkan tipe */
    private void filterByType(String type) {
        tableView.getItems().setAll(
            cinemaList.stream().filter(m -> m.getType().equals(type)).toList());
    }

    /**Pencarian berdasarkan judul */
    @FXML
    public void searchCinema() {
        String keyword = searchField.getText().toLowerCase();

        tableView.getItems().clear();

        for (CinemaItem m : cinemaList) {
            if (m.getTitle().toLowerCase().contains(keyword)) {
                tableView.getItems().add(m);
            }
        }
    }

    /**Menandai film yang sudah ditonton */
    @FXML
    public void marked() {
        CinemaItem selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null && selected instanceof Marked m) {
            m.setMark(true);
            tableView.refresh();
            MediaStorage.saveAsync(cinemaList);
        }
    }

    /**Menambah film/series baru */
    @FXML
    public void addCinema() {
        String title = titleField.getText();
        String ratingText = ratingField.getText();
        String desc = descArea.getText();
        String type = typeBox.getValue();
        String genre = genreBox.getValue();

        //validasi jika judul kosong
        if (title.isEmpty() || ratingText.isEmpty() || type == null) {
            showAlert("Error", "Title, Type, dan Rating wajib diisi!");
            return;
        }

        //validasi rating
        double rating;
        try {
            rating = Double.parseDouble(ratingText);
        } catch (NumberFormatException e) {
            showAlert("Error", "Rating harus berupa angka (contoh: 4.5)");
            return;
        }
        if (rating < 0 || rating > 5) {
            showAlert("Error", "Rating harus antara 0 sampai 5!");
            return;
        }

        //membuat objek Cinema item sesuai tipe
        CinemaItem item = switch (type) {
            case "Movie" -> new Movie(title, rating, desc, genre);
            default -> new Series(title, rating, desc, genre);
        };
        //menambahkan ke list dan tabel
        cinemaList.add(item);
        tableView.getItems().add(item);
        //simpan ke file scr asinkron
        MediaStorage.saveAsync(cinemaList);
        clearForm();
    }

    /**Menghapus data */
    @FXML
    public void deleteCinema() {
        CinemaItem selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cinemaList.remove(selected);
            tableView.getItems().remove(selected);
            MediaStorage.saveAsync(cinemaList); //simpan perubahan
        }
    }

    /**Menampilkan dialog error */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**Membersihkan form */
    private void clearForm() {
        titleField.clear();
        ratingField.clear();
        descArea.clear();

        typeBox.setValue(null);
        genreBox.setValue(null);
    }
}
