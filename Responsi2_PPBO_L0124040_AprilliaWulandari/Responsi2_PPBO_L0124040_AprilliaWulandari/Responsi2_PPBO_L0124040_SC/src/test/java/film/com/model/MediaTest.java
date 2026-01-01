package film.com.model;

import static org.junit.jupiter.api.Assertions.*; //utk JUnit
import org.junit.jupiter.api.Test;

/**
* Kelas {@code MediaTest} berisi
* pengujian unit untuk kelas model.
*
* @author aprliwln
*/
public class MediaTest {

    /**
    * Menguji tipe dan genre Movie.
    */
    @Test
    void testMovieTypeAndGenre() {
        CinemaItem movie = new Movie("Interstellar", 4.5, 
                        "Tentang Blackholes", "Sci-Fi");
        //memastikan type movie benar
        assertEquals("Movie", movie.getType());
        //memastikan genre movie benar
        assertEquals("Sci-Fi", movie.getGenre());
    }

    /**
    * Menguji tipe dan genre Series.
    */
    @Test
    void testSeriesType() {
        CinemaItem series = new Series("Stranger Things", 4.8, 
                        "Misteri di Hawkins", "Thriller");
        //memastikan type series benar
        assertEquals("Series", series.getType());
        //memastikan genre series benar
        assertEquals("Thriller", series.getGenre());
    }
}
