public class Basdat extends MataKuliah implements Penilaian {
    
    //constructor
    public Basdat (double nilai) {
        //memanggil konstruktor induk
        super("Basis Data", 4, nilai);
    }

    @Override
    public double getBobotNilai() {
        return 0.95;
    }

    @Override
    public double hitungNilaiAkhir() {
        return nilai * getBobotNilai();
    }

    @Override
    public String getGrade() {
        if (nilai >= 85) return "A"; 
        if (nilai >= 80) return "A-"; 
        if (nilai >= 75) return "B+"; 
        if (nilai >= 70) return "B"; 
        if (nilai >= 65) return "C+"; 
        if (nilai >= 60) return "C"; 
        if (nilai >= 55) return "D";
        return "E"; 
    }
}
