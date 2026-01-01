import java.util.ArrayList;

//kelas penumpang
public class Passenger {
    public String name;
    private String dateOfBirth;
    private String nomor;
    protected String email;

    //konstruktor penumpang
    public Passenger(String name, String dateOfBirth, String nomor, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nomor = nomor;
        this.email = email;
    }

    //untuk menyimpan daftar seluruh penumpang
    static ArrayList<Passenger> listPassengers = new ArrayList<>();

    //getter untuk tanggal lahir krn private
    public String getDate() {
        return dateOfBirth;
    }

    //setter untuk tgl lahir
    public void setDate (String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //getter untuk nomer telpon krn private
    public String getNomor() {
        return nomor;
    }

    //setter untuk nomer telpon
    public void setNomor (String nomor) {
        this.nomor = nomor;
    }

    //untuk mencari penumpang berdasarkan nama dan nomer telpon (unik)
    public static Passenger findPassenger (String usn, String num) {
        for (Passenger p: listPassengers){
            //tidak sensitif terhdap hurud besar atau kecil
            if (p.name.equalsIgnoreCase(usn) && p.nomor.equals(num)) {
                return p; //ditemukam
            }
        }
        return null; //tdk ditemukan
    }
}
