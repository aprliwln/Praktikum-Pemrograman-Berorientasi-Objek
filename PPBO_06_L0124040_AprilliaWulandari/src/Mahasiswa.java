public class Mahasiswa {
    private String NIM;
    private String nama;
    private int nilai;

    public Mahasiswa (String NIM, String nama, int nilai) {
        this.NIM = NIM;
        this.nama = nama;
        this.nilai = nilai;
    }

    //getter untuk mendapatkan variabel yang diprivate
    public String getNIM() {
        return NIM;
    }
    public String getNama() {
        return nama;
    }
    public int getNilai() {
        return nilai;
    }
}
