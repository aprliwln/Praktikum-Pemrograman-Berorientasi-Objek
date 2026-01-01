public class Sisop extends MataKuliah implements Penilaian{
    
    //constructor
    public Sisop (double nilai) {
        //memanggil konstruktor induk
        super("Sistem Operasi", 3, nilai);
    }

    @Override
    public double getBobotNilai() {
        return 0.83;
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
