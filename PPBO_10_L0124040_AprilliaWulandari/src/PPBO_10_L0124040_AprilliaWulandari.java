//Aprillia Wulandari - L0124040

public class PPBO_10_L0124040_AprilliaWulandari {
    public static void main(String[] args) throws Exception {
        Karyawan[] daftarKaryawan = new Karyawan[4];

        //tanmbah karyawan
        daftarKaryawan[0] = new KaryawanGajiTetap
                            ("Y01", "Akito Yamada", 3000000);
        daftarKaryawan[1] = new KaryawanPerJam
                            ("K01", "Akabane Karuma", 50000, 40);
        daftarKaryawan[2] = new KaryawanKomisi
                            ("K02", "Tsukishima Kei", 50000000, 0.10);
        daftarKaryawan[3] = new KaryawanKomisiPlus
                            ("R01", "Edogawa Ranpo", 55000000, 0.10, 1000000);

        System.out.println("===========================================");
        System.out.println("        DAFTAR GAJI MINGGUAN KARYAWAN      ");
        System.out.println("===========================================");
        System.out.printf("%-5s | %-20s | %-10s\n", "ID", "Nama", "Gaji");
        System.out.println("-------------------------------------------");
        for (Karyawan k: daftarKaryawan) {
            System.out.printf("%-5s | %-20s | Rp %.0f\n", k.getId(), k.getNama(), k.hitungGaji());
        }
        System.out.println("-------------------------------------------");
    }
}

/*
i.  Bagaimana polimorfisme yang diterapkan bisa mempermudah perhitungan gaji perusahaan? 
    Jawab:
    Polimorfisme yang diterapkan bisa mempermudah perhitungan gaji perusahaan dengan
    runtime polymorphism (overriding). Dalam kode yang dibuat, program cukup memanggil
    method "hitungGaji()" tanpa tahu jenis karyawannya. Hal ini membuat perhitungan gaji
    mudah diperluas dan tidak perlu banyak if-else untuk tiap tipe karyawan

ii. Apakah program masih dapat bekerja sesuai fungsinya jika tidak menggunakan polimorfisme? Berikan alasannya
    Jawab:
    Program masih dapat bekerja sesuai fungsinya walaupun tidak menggunakan poliformisfe, tetapi tidak efisien.
    Hal ini karena, program harus menggunakan banyak pengecekan (if-else) sehingga kode menjadi panjang, sulit
    untuk di maintenance, dan juga sulit untuk ditambah tipe karyawan baru. Oleh karena itu, penggunaan
    polimorfisme membuat program lebih modular dan efisien.
*/