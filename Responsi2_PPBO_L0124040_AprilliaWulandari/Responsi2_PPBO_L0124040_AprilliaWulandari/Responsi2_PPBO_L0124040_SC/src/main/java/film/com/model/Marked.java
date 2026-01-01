package film.com.model;

/**
* Interface {@code Marked} digunakan untuk menandai
* media yang sudah ditonton.
* <p>
* Interface ini diimplementasikan oleh
* {@link Movie} dan {@link Series}.
* </p>
*
* @author aprliwln
*/
public interface Marked {
    /**
    * Mengubah status penandaan media.
    *
    * @param mark true jika sudah ditonton
    */
    void setMark(boolean mark); 

    /**
    * Mengecek status penandaan media.
    *
    * @return true jika sudah ditonton
    */
    boolean isMarked();         
}
