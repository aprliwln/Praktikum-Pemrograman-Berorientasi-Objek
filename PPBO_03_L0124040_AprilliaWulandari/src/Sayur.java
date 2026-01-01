import java.util.ArrayList;

public class Sayur {
    String name;
    int stock;
    String entryDate;

    //konstruktor
    public Sayur(String name, int stock, String entryDate){
        this.name = name;
        this.stock = stock;
        this.entryDate = entryDate;
    }

    //untuk menyimpan seluruh data sayur
    static ArrayList<Sayur> listSayur = new ArrayList<>();

    //untuk menambahkan data sayur baru ke dalam list
    public static void addSayur (String name, int stock, String entryDate) {
        //validasi format input
        if (name.length() <= 6) {
            System.out.println("Gunakan format 'sayur <nama>' ");
        }
        else {
            //mengambil nama sayur tanpa kata "sayur "
            String vegName = name.substring(6);
            listSayur.add(new Sayur(vegName, stock, entryDate));
            System.out.println("" + vegName + " berhasil ditambahkan");
        }
    }

    //untuk menampilkan seluruh data sayur
    public static void printSayur(){
        System.out.println("============================================");
        System.out.println("                  LIST SAYUR                ");
        System.out.println("============================================");
        
        //jika data sayur masih kosong
        if (listSayur.isEmpty()) {
            System.out.println("Empty vegetable");
        }
        else {
            System.out.printf("%-15s | %-10s | %-15s\n", "Nama", "Stok", "Tanggal Masuk");
            System.out.println("---------------------------------------------");
            for (Sayur sayur: listSayur) {
                System.out.printf("%-15s | %-10d | %-15s\n", sayur.name, sayur.stock, sayur.entryDate);
            }
        }
        System.out.println("---------------------------------------------");
    }
}
