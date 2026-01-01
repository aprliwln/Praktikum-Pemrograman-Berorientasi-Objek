public class Matdis extends MataKuliah implements Penilaian{
    
    //constructor
    public Matdis (double nilai) {
        //memanggil konstruktor induk
        super("Matematika Diskrit", 2, nilai);
    }

    @Override
    public double getBobotNilai() {
        return 0.85;
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
