public abstract class Karyawan {
    private String id;
    private String nama;

    public Karyawan (String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }

    public abstract double hitungGaji(); 
}
