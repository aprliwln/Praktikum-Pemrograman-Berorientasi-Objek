public class Stuff {
    //konstanta
    public static final int MIN_STOK = 10;
    //static variabel
    static int totalUse = 0;
    static int totalItemUsed = 0;
    
    //non-static variabels
    String name;
    String category;
    int stock;
    int unitePrice;
    int totalInventaris;

    //constructor
    public Stuff (String name, String category, int stock, int unitePrice) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.unitePrice = unitePrice;
        this.totalInventaris = stock * unitePrice;
    }

    //tambah stok
    public void addStock (int quantity) {
        if (quantity < 1) { //stok yg dimasukan minimal 1
            System.out.println("Quantity must be at least 1");
            return;
        }

        stock += quantity; //update stok
        totalInventaris = stock * unitePrice; //update total nilai inventaris
        System.out.println("Stock added successfully");
    }

    //pakai barang
    public void useStuff (int quantity) {
        //variabel lokal
        int newStock;

        if (quantity < 1) { //item yg mau dipakai minimal 1
            System.out.println("The quantity must be at least one");
            return;
        }

        if (quantity > stock) { //jika jumlah item yg mau digunakan lebih bnyk dri stok
            System.out.println("Insufficient stock. Available: " + stock);
            return;
        }

        newStock = stock - quantity; //sisa stok
        stock = newStock; //update stok
        totalInventaris = stock * unitePrice; //update total nilai inventaris
        totalUse++; //total transaksi pemakaian barang
        totalItemUsed += quantity; //total semua item yang dipakai
        System.out.println("Total item used: " + totalItemUsed);

        if (stock < MIN_STOK) { //jika stok kurang dari minimum stok
            System.out.println("Warning! The stock of " + name + " is " + stock);
            System.out.println("Please restock this item");
        }
    }

    //tampilan list di layar
    public void display() {
        System.out.printf("%-15s | %-15s | %5d | %10d | %12d\n",
        name, category, stock, unitePrice, totalInventaris);
    }
}