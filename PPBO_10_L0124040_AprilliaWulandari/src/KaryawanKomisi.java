public class KaryawanKomisi extends Karyawan {
    protected double penjualan;
    protected double persenKomisi;

    public KaryawanKomisi (String id, String nama, double penjualan, double persenKomisi) {
        super(id, nama);
        this.penjualan = penjualan;
        this.persenKomisi = persenKomisi;
    }

    @Override
    public double hitungGaji() {
        return penjualan * persenKomisi;
    }
}
