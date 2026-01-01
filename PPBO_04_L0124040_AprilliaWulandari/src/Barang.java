import java.util.ArrayList;

//kelas barang
public class Barang {
    public String nama;
    public String category;
    private float harga;
    private int stok;

    //konstruktor barang
    public Barang(String nama, String category, float harga, int stok) {
        this.nama = nama;
        this.category = category;
        this.harga = harga;
        this.stok = stok;
    }

    //untuk menyimoan daftar seluruh barang
    static ArrayList<Barang> listBarang = new ArrayList<>();

    //getter untuk harga krn private
    public float getHarga() {
        return harga;
    }

    //getter untuk stok krn private
    public int getStok() {
        return stok;
    }

    //setter untuk stok
    public void setStok(int stok) {
        this.stok = stok;
    }

    //inisialisasi daftar barang
    public static void barang(){
        listBarang.add(new Barang("Roti", "Makanan", 6000, 12));
        listBarang.add(new Barang("Mie Sedap", "Makanan", 3000, 50));
        listBarang.add(new Barang("Oreo", "Makanan", 8000, 20));
        listBarang.add(new Barang("Silver Queen", "Makanan", 15000, 11));
        listBarang.add(new Barang("Ice Cream", "Makanan",10000, 31));
        listBarang.add(new Barang("Aqua", "Minuman", 4000, 45));
        listBarang.add(new Barang("Good Day", "Minuman", 5000, 27));
        listBarang.add(new Barang("Indomilk", "Minuman", 8000, 23));
        listBarang.add(new Barang("Pocari Sweet", "Minuman", 9000, 18));
        listBarang.add(new Barang("Teh Kotak", "Minuman", 5000, 41));
        listBarang.add(new Barang("Handbody", "Perawatan Diri", 20000, 14));
        listBarang.add(new Barang("Sabun", "Perawatan Diri", 3000, 10));
        listBarang.add(new Barang("Shampoo", "Perawatan Diri", 8000, 5));
        listBarang.add(new Barang("Odol", "Perawatan Diri", 7000, 8));
        listBarang.add(new Barang("Sikat", "Perawatan Diri", 5000, 6));
        listBarang.add(new Barang("Paracetamol", "Kesehatan", 12500, 19));
        listBarang.add(new Barang("Kayu Putih", "Kesehatan", 15000, 8));
        listBarang.add(new Barang("Plester", "Kesehatan", 5000, 24));
        listBarang.add(new Barang("Masker", "Kesehatan", 3000, 37));
        listBarang.add(new Barang("Antiseptik", "Kesehatan", 10000, 5));
    }

    //untuk mencari barang berdasarkan nama
    public static Barang findBarang(String name) {
        for (Barang b: listBarang) {
            //tidak sensitif terhadap huruf besar atau kecil
            if (b.nama.equalsIgnoreCase((name))) {
                return b;
            }
        }
        return null;
    }

    //untuk menampilkan daftar barang
    public static void display() {
        System.out.println("=====================================================");
        System.out.println("                DAFTAR BARANG TOKO EYP               ");
        System.out.println("=====================================================");

        //validasi jika tidak terdapat daftar barang
        if (listBarang.isEmpty()) {
            System.out.println("Daftar barang tidak tersedia");
        }
        else {
            System.out.printf("%-15s | %-15s | %-10s | %-5s\n", 
            "Nama", "Kategori", "Harga (Rp)", "Stok");
            System.out.println("-----------------------------------------------------");
            for (Barang b : listBarang) {
                System.out.printf("%-15s | %-15s | %-10.2f | %-5d\n", 
                b.nama, b.category, b.harga, b.stok);
            }
        }
        System.out.println("-----------------------------------------------------");
    }
}

