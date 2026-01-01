package film.com.model;

/**
* Kelas abstrak {@code CinemaItem} merepresentasikan
* media hiburan berupa movie atau series.
* <p>
* Kelas ini menjadi parent (superclass) bagi
* {@link Movie} dan {@link Series}.
* </p>
*
* @author aprliwln
*/

public abstract class CinemaItem{
    /**Judul media */
    protected String title; 
    //*Rating media (0-5) */        
    protected double rating; 
    /**Deskripsi singkat media */      
    protected String description;   
    /**Genre media */
    protected String genre;        

    /**
    * Konstruktor untuk membuat objek CinemaItem.
    *
    * @param title judul media
    * @param rating rating media
    * @param description deskripsi media
    * @param genre genre media
    */
    public CinemaItem(String title, double rating, String description, String genre) {
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.genre = genre;
    }

    /**@return judul media */
    public String getTitle() { return title; }
    /**@return rating media */
    public double getRating() { return rating; }
    /**@return deskripsi media */
    public String getDescription() { return description; }
    /**@return genre media */
    public String getGenre() { return genre;}

    /**
    * Mengembalikan tipe media.
    *
    * @return "Movie" atau "Series"
    */
    public abstract String getType();
}
