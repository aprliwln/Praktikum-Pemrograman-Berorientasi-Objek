import java.util.ArrayList;

public class Mahasiswa {
    private String nama;
    private String NIM;
    private ArrayList<MataKuliah> listMatkul = new ArrayList<>();
    
    //contructor
    public Mahasiswa (String nama, String NIM) {
        this.nama = nama;
        this.NIM = NIM;
    }

    //menambahkan matkul yg diambil mahasiswa
    public void addMatkul(MataKuliah mk) {
        listMatkul.add(mk);
    }

    //total sks yg diambil
    public int totalSks() {
        int total = 0;
        for (MataKuliah mk: listMatkul) {
            total += mk.getSks();
        }
        return total;
    }

    //total nilai akhir
    public double nilaiAkhir() {
        double total = 0;
        for (MataKuliah mk: listMatkul){
            total += mk.hitungNilaiAkhir() * mk.getSks();
        }
        return total / totalSks();
    }

    //untuk tampilkan matkul beserta gradenya
    public String matkulGrade() {
        if (listMatkul.isEmpty()) return "Empty";

        String matkul = "";
        for (MataKuliah mk: listMatkul) {
            String grade = ((Penilaian) mk).getGrade();
            matkul += mk.getNama() + " (" + grade + "), ";
        }
        return matkul.substring(0, matkul.length() - 2);
    }

    //getter
    public String getNama() {return nama;}
    public String getNIM() {return NIM;}
    public ArrayList<MataKuliah> getMatkul() {return listMatkul;}
}
