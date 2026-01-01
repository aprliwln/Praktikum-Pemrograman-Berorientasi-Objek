/*
Nama: Aprillia Wulandari
NIM : L0124040
*/

import java.util.Scanner;

public class Main { 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Barang.barang(); //inisialisasi daftar barang
        ShoppingCart keranjang = new ShoppingCart();

        try {
            //selama kondisi benar atau tidak memasukkan 5, maka akan terus mengulang 
            while (true) {
                System.out.println("====================================");
                System.out.println("            MENU TOKO EYP           ");
                System.out.println("====================================");
                System.out.println("       [1] Daftar Barang            ");
                System.out.println("       [2] Tambah Ke Keranjang      ");
                System.out.println("       [3] Lihat Keranjang          ");
                System.out.println("       [4] Checkout                 ");
                System.out.println("       [5] Exit                     ");
                System.out.println("------------------------------------");
                System.out.print("Input option: ");
                int option = sc.nextInt();
                sc.nextLine();

                //case akan berjalan sesuai dengan input user
                switch (option) {
                    case 1:
                        Barang.display();
                        break;
                    case 2:
                        Barang.display();
                        System.out.print("Nama barang: ");
                        String name = sc.nextLine();
                        Barang b = Barang.findBarang(name);
                        //validasi jika item tidak ditemukan
                        if (b == null) {
                            System.out.println("Barang tidak ditemukan");
                            break;
                        }

                        System.out.print("Jumlah barang: ");
                        int jumlah = sc.nextInt();
                        sc.nextLine();

                        try {
                            keranjang.addItems(b, jumlah);
                        } 
                        //menampilkan pesan kesalahan input yg diambil dari assert
                        catch (AssertionError e) {
                            System.out.println("Kesalahan Input: " + e.getMessage());
                        }
                        break;
                    case 3:
                        keranjang.displayCart();
                        break;
                    case 4:
                        if (keranjang.item.isEmpty()) {
                            System.out.println("Keranjang kosong!");
                            break;
                        }
                        keranjang.displayCart();
                        System.out.println("Lanjut Checkout?");
                        System.out.println("[1] Ya");
                        System.out.println("[2] Tidak");
                        System.out.print("Input option: ");
                        int confirm = sc.nextInt();
                        sc.nextLine();
                        //validasi jika user melanjutkan checkout
                        if (confirm == 1) {
                            System.out.println("Thanks for shopping");
                            return;
                        }
                        else {
                            System.out.println("Checkout dibatalkan. Kembali ke menu");
                        }
                        break;
                    case 5:
                        System.out.println("Exit...");
                        return;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        } 
        //menangkap dan menampilkan pesan error
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        //memastikan scanner selalu ditutup meski terjadi error
        finally {
            sc.close();
        }
    }
}
