import java.util.Scanner;

public class Main {

    //mengecek dan memproses input user
    public static void checkInput (Scanner sc, int jumlah) {
        String[] kategori = {"buah", "sayur"};

        //perulangan untuk input beberapa data
        for (int i = 0; i < jumlah; i++) {
            System.out.print("Buah/Sayur <nama>:  ");
            String name = sc.nextLine();
            boolean valid = false; //inisialisasi apakah input sesuai format
                
            //mengecek apakah input diawali kata "buah " atau "sayur "
            for (String kat: kategori) {
                //jika input user sesuai format
                if (name.toLowerCase().startsWith(kat + " ")) {
                    valid = true;

                    System.out.print("Stok: ");
                    int stok = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tanggal masuk (dd-mm-YYYY): ");
                    String date = sc.nextLine();

                    //menentukan data termasuk dalam kategori buah atau sayur
                    if (kat.equals("buah")) {
                        Buah.addBuah(name, stok, date);
                    }
                    else {
                        Sayur.addSayur(name, stok, date);
                    }
                    break;
                }
            }

            //jika tidak sesuai format
            if (!valid) {
                System.out.println("Invalid format! Gunakan 'buah <nama>' / 'sayur <nama>'");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        //menu utama
        while (true) {
            System.out.println("====================================");
            System.out.println("     PENCATATAN BUAH DAN SAYURAN    ");
            System.out.println("====================================");
            System.out.println("       [1] Tambah Sayur/Buah        ");
            System.out.println("       [2] Daftar Buah              ");
            System.out.println("       [3] Daftar Sayur             ");
            System.out.println("       [4] Exit                     ");
            System.out.println("------------------------------------");
            System.out.print("Input option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Jumlah masukan: ");
                    int jumlah = sc.nextInt();
                    sc.nextLine();
                    checkInput(sc, jumlah);
                    break;
                case 2:
                    Buah.printBuah();
                    break;
                case 3:
                    Sayur.printSayur();
                    break;
                case 4:
                    System.out.println("Terima kasih telah mencoba ^_^!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
