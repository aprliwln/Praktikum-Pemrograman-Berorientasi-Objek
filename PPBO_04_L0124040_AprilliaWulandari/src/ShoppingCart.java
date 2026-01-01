import java.util.ArrayList;

//kelas shopping cart atau keranjang untuk menyimpan barang yang ingin dibeli
public class ShoppingCart {
    ArrayList<Barang> item = new ArrayList<>(); //list barang di keranjang
    ArrayList<Integer> totalItem = new ArrayList<>(); //jumlah tiap barang

    //menambah barang ke keranjang
    public void addItems(Barang b, int jumlah) {
        try {
            //validasi jika barang tidak ditemukan
            if (b == null) {
                throw new Exception("Barang tidak ditemukan");
            }

            //validasi jika user memasukkan jumlah barang kurang dari 1
            if (jumlah <= 0) {
                System.out.println("Jumlah pembelian minimal 1");
                return;
            }

            //sama seperti di atasnya, bedanya akan berjalan jika di run manual
            assert jumlah > 0 : "Jumlah pembelian minimal 1";

            //validasi untuk mengecek stok barang
            if (jumlah <= b.getStok()) {
                //jika stok mencukupi dan sudah ada barangnya di keranjang
                boolean found = false;
                for (int i = 0; i < item.size(); i++) {
                    if (item.get(i).nama.equalsIgnoreCase(b.nama)) {
                        //jumlah barang di keranjang ditambah
                        totalItem.set(i, totalItem.get(i) + jumlah);
                        //stok dikurangin
                        b.setStok(b.getStok() - jumlah);
                        found = true;
                        break;
                    }
                }

                //jika belum ada barangnya dikeranjang
                if (!found) {
                    item.add(b); //item ditambahkan ke keranjang
                    totalItem.add(jumlah); //jumlah item ditambahkan ke keranjang
                    b.setStok(b.getStok() - jumlah); //stok dikurangi
                }
                System.out.println(b.nama + " berhasil ditambahkan ke keranjang");
            }
            else {
                System.out.println("Stok tidak mencukupi. Stok tersedia: " + b.getStok());
            }
        } 
        //menangkap dan menampilkan pesan error
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //untuk menghitung total harga seluruh isi keranjang
    public float totalPrice() {
        float total = 0;
        for (int i = 0; i < item.size(); i++) {
            total += item.get(i).getHarga() * totalItem.get(i);
        }
        return total;
    }

    //menampilkan isi keranjang
    public void displayCart() {
        System.out.println("============================================");
        System.out.println("              DAFTAR KERANJANG            ");
        System.out.println("============================================");
        //validasi jika keranjang kosong
        if (item.isEmpty()) {
            System.out.println("Keranjang kosong!");
        }
        else {
            System.out.printf("%-15s | %-8s | %-10s \n",
            "Nama", "Jumlah", "Total Harga");
            System.out.println("---------------------------------------------");
            for(int i = 0; i < item.size(); i++) {
                Barang b = item.get(i);
                int jumlah = totalItem.get(i);

                System.out.printf("%-15s | %-8d | %-10.2f\n",
                b.nama, jumlah, b.getHarga() * jumlah);
            }
            System.out.println("---------------------------------------------");
            System.out.printf("TOTAL: Rp%.2f\n", totalPrice());
            System.out.println("---------------------------------------------");
        }
    }
}
