public class Nilai implements Runnable{
    private Mahasiswa mhs;

    //constructor
    public Nilai(Mahasiswa mhs) {
        this.mhs = mhs;
    }

    @Override
    public void run() {
        //dicetak oleh thread berbeda (urutan acak)
        System.out.println(Thread.currentThread().getName() + 
                            "\nNama        : " + mhs.getNama() +
                            "\nNIM         : " + mhs.getNIM() +
                            "\nMata Kuliah : " + mhs.matkulGrade() +
                            "\nTotal SKS   : " + mhs.totalSks() +
                            "\nNilai Akhir : " + mhs.nilaiAkhir() +
                            "\n---------------------------------");
    }
}
