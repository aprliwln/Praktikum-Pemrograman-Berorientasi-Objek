package film.com.model;

/**
* Kelas {@code Series} merepresentasikan
* serial televisi atau web series.
*
* @author aprliwln
*/
public class Series extends CinemaItem implements Marked{
    /**Status apakah series sudah ditonton */
    private boolean marked = false;
    
    /**
    * Konstruktor Series.
    *
    * @param title judul series
    * @param rating rating series
    * @param description deskripsi series
    * @param genre genre series
    */
    public Series(String title, double rating, String description, String genre) {
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
    * @return "Series"
    */
    @Override
    public String getType() {
        return "Series";
    }
}
