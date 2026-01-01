package film.com.model;

/**
* Kelas {@code Movie} merepresentasikan
* film layar lebar.
*
* @author aprliwln
*/
public class Movie extends CinemaItem implements Marked{
    /**Status apakah film sudah ditonton */
    private boolean marked = false;

    /**
    * Konstruktor Movie.
    *
    * @param title judul film
    * @param rating rating film
    * @param description deskripsi film
    * @param genre genre film
    */
    public Movie(String title, double rating, String description, String genre) {
        //panggil constructor induk (CinemaItem)
        super(title, rating, description, genre); 
    }

    /**{@inheritDoc} */
    @Override
    public void setMark(boolean mark) {
        this.marked = mark; //set status marked
    }
    /**{@inheritDoc} */
    @Override
    public boolean isMarked() {
        return marked; //ambil status marked saat ini
    }

    /**
    * Mengembalikan tipe media.
    *
    * @return "Movie"
    */
    @Override
    public String getType() {
        return "Movie";
    }
}
