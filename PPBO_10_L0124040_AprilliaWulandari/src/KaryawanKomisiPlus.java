public class KaryawanKomisiPlus extends KaryawanKomisi {
    private double gajiPokok;

    public KaryawanKomisiPlus (String id, String nama, double penjualan, double persenKomisi, double gajiPokok) {
        super(id, nama, penjualan, persenKomisi);
        this.gajiPokok = gajiPokok;
    }

    //tmbhan bonus 10% 
    @Override
    public double hitungGaji() {
        double bonus = gajiPokok * 0.1;
        return gajiPokok + bonus + (penjualan * persenKomisi);
    }

    //operator polymorphism menambah gaji pokok
    public void tambahGaji (double tambahan) {
        this.gajiPokok += tambahan;
    }

    //overloading
    public void tambahGaji (double tambahan, double bonusEkstra) {
        this.gajiPokok += (tambahan + bonusEkstra);
    }
}
