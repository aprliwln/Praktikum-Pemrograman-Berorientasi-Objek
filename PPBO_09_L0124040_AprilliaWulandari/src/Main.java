/*
Nama: Aprillia Wulandari
NIM : L0124040 
*/

public class Main {
    public static void main(String[] args) throws Exception {
        //membuat 3 objek subclass
        RamuanMetaformosis r1 = new RamuanMetaformosis ("Elixir Lumora", 6, 
                                150.0, true, "Makhluk Cahaya", 35);
        RamuanMetaformosis r2 = new RamuanMetaformosis("Morph Essence", 8, 
                                120.5, false, "Serigala Aether", 50);
        RamuanMetaformosis r3 = new RamuanMetaformosis("Shadowveil", 9, 
                                90.0, false, "Bayangan Hitam", 25);

        //menampilkan info lengkap setiap objek
        r1.tampilkanDetailRamuan();
        r2.tampilkanDetailRamuan();
        r3.tampilkanDetailRamuan();

        //memanggil methode tambahan superclass
        r2.adukRamuan();
        //memanggil methode unik subclass
        r2.aktifkanMantra();
    }
}
