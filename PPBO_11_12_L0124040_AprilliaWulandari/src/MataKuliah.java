public abstract class MataKuliah {
    protected String nama;
    protected int sks;
    protected double nilai;

    //constructor
    public MataKuliah (String nama, int sks, double nilai) {
        this.nama = nama;
        this.sks = sks;
        this.nilai = nilai;
    }

    //getter
    public String getNama() {return nama;}
    public int getSks() {return sks;}
    public double getNilai() {return nilai;}

    //setiap matkul punya bobot dan cara hitung berbeda
    public abstract double hitungNilaiAkhir();
}
