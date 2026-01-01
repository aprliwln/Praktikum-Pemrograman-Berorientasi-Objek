public class KaryawanPerJam extends Karyawan{
    private double upahPerJam;
    private int jamKerja;

    //overloading tanpa lembur
    public KaryawanPerJam (String id, String nama, double upahPerJam, int jamKerja) {
        super(id, nama);
        this.upahPerJam = upahPerJam;
        this.jamKerja = jamKerja;
    }

    //overloading dgn lembur
    public KaryawanPerJam (String id, String nama, double upahPerJam, int jamKerja, int lembur) {
        super(id, nama);
        this.upahPerJam = upahPerJam;
        this.jamKerja = jamKerja + lembur;
    }

    @Override
    public double hitungGaji() {
        return upahPerJam * jamKerja;
    }
}
