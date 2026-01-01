import java.util.ArrayList;

public class Buah {
    String name;
    int stock;
    String entryDate;

    //konstruktor
    public Buah(String name, int stock, String entryDate){
        this.name = name;
        this.stock = stock;
        this.entryDate = entryDate;
    }

    //untuk menyimpan seluruh data buah
    static ArrayList<Buah> listBuah = new ArrayList<>();

    //untuk menambahkan data buah baru ke dalam list
    public static void addBuah (String name, int stock, String entryDate){
        //validasi format input
        if (name.length() <= 5) {
            System.out.println("Gunakan format 'buah <nama>' ");
        }
        else{
            //mengambil nama buah tanpa kata "buah "
            String fruitName = name.substring(5);
            listBuah.add(new Buah(fruitName, stock, entryDate));
            System.out.println("" + fruitName +" berhasil ditambahkan");
        }
    }

    //untuk menampilkan seluruh daftar buah
    public static void printBuah(){
        System.out.println("============================================");
        System.out.println("                  LIST BUAH                 ");
        System.out.println("============================================");
        
        //jika daftar buah masih kosong
        if (listBuah.isEmpty()) {
            System.out.println("Empty fruits");
        }
        else {
            System.out.printf("%-15s | %-10s | %-15s\n", "Nama", "Stok", "Tanggal Masuk");
            System.out.println("---------------------------------------------");
            for (Buah fruit: listBuah) {
                System.out.printf("%-15s | %-10d | %-15s\n", fruit.name, fruit.stock, fruit.entryDate);
            }
        }
        System.out.println("---------------------------------------------");
    }
}
