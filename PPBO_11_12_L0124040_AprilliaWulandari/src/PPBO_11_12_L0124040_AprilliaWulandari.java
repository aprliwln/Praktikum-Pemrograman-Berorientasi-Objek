//Nama: Aprillia Wulandari
//NIM : L0124040

public class PPBO_11_12_L0124040_AprilliaWulandari {
    public static void main(String[] args) throws Exception {

        //membuat 5 objek mahasiswa & matkul yang diambil
        Mahasiswa m1 = new Mahasiswa("April", "L0124040");
        m1.addMatkul(new PBO(85));
        m1.addMatkul(new Basdat(90));
        m1.addMatkul(new Matdis(88));

        Mahasiswa m2 = new Mahasiswa("Ardina", "L0124041");
        m2.addMatkul(new PBO(80));
        m2.addMatkul(new Sisop(75));
        m2.addMatkul(new Metnum(92));

        Mahasiswa m3 = new Mahasiswa("Khashia", "L0124059");
        m3.addMatkul(new PBO(88));
        m3.addMatkul(new Matdis(79));
        m3.addMatkul(new Sisop(87));

        Mahasiswa m4 = new Mahasiswa("Erika", "L0124049");
        m4.addMatkul(new PBO(90));
        m4.addMatkul(new Metnum(82));
        m4.addMatkul(new Matdis(85));

        Mahasiswa m5 = new Mahasiswa("Calista", "L0124092");
        m5.addMatkul(new PBO(80));
        m5.addMatkul(new Sisop(83));
        m5.addMatkul(new Basdat(77));

        Mahasiswa[] list = {m1, m2, m3, m4, m5};

        //single thread
        long startSingle = System.currentTimeMillis();
        System.out.println("=================================");
        System.out.println("          SINGLE THREAD          ");
        System.out.println("=================================");
        for (Mahasiswa m: list) {
            double nilaiAkhir = m.nilaiAkhir();
            System.out.println("Nama        : " + m.getNama());
            System.out.println("NIM         : " + m.getNIM());
            System.out.println("Mata Kuliah : " + m.matkulGrade());
            System.out.println("Total SKS   : " + m.totalSks());
            System.out.println("Nilai Akhir : " + nilaiAkhir);
            System.out.println("---------------------------------");
        }
        long endSingle = System.currentTimeMillis();
        System.out.println("Waktu eksekusi: " + (endSingle - startSingle) + " ms\n");

        //multi thread
        long startMulti = System.currentTimeMillis();
        System.out.println("\n=================================");
        System.out.println("           MULTI THREAD          ");
        System.out.println("=================================");
        Thread[] threads = new Thread[list.length];

        //setiap mahasiswa diproses di thread berbeda
        for (int i = 0; i < list.length; i++) {
            threads[i] = new Thread(new Nilai(list[i]));
            threads[i].start();
        }
        for (Thread t: threads) {
            t.join(); //menunggu semua thread selesai
        }
        long endMulti = System.currentTimeMillis();
        System.out.println("Waktu eksekusi: " + (endMulti - startMulti) + " ms\n");
    }
}
