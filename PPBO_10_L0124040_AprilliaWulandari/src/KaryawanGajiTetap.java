public class KaryawanGajiTetap extends Karyawan{
    private double gajiMingguan;

    public KaryawanGajiTetap (String id, String nama, double gajiMingguan) {
        super(id, nama);
        this.gajiMingguan = gajiMingguan;
    }

    @Override
    public double hitungGaji() {
        return gajiMingguan;
    }
}
