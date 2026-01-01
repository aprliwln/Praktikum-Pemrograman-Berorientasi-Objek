//import class Scanner dari package java.util
import java.util.ArrayList;

public class Inventory {
    //objek ArrayList untuk menyimpan semua item
    ArrayList<Stuff> listItem = new ArrayList<>();

    //konstruktor list awal barang
    public Inventory(){
        listItem.add(new Stuff("A4 Paper", "Stationery", 50, 37500));
        listItem.add(new Stuff("Pen", "Stationery", 100, 1500));
        listItem.add(new Stuff("Laptop", "Elektronics", 10, 8000000));
        listItem.add(new Stuff("Calculator", "Elektronics", 10, 200000));
        listItem.add(new Stuff("Desk", "Furniture", 20, 1000000));
        listItem.add(new Stuff("Chair", "Furniture", 30, 500000));
        listItem.add(new Stuff("Printer", "Elektronics", 15, 800000));
        listItem.add(new Stuff("Whiteboard", "Furniture", 8, 350000));
        listItem.add(new Stuff("Stapler", "Stationery", 25, 25000));
    }

    //method untuk mendapatkan item
    public ArrayList<Stuff> getItems() {
        return listItem;
    }

    //method untuk mencari item berdasarkan namanya
    public Stuff findItem (String nm) {
        for (Stuff s :listItem) {
            if (s.name.equalsIgnoreCase(nm)) {
                return s;
            }
        }
        return null;
    } 

    //method untuk tambah stok
    public void tambahStok(String name, int total) {
        Stuff item = findItem(name); //mencocokkan nama item
        if (item != null) { //jika nama item terdapat di daftar
            item.addStock(total);
        }
        else {
            System.out.println("Item not found");
        }
    }

    //method untuk menggunakan barang
    public void pakaiBarang(String name, int total) {
        Stuff itemUse = findItem(name); //mencocokkan nama item
        if (itemUse != null) { //jika nama item terdapat di daftar
            itemUse.useStuff(total);
            System.out.println("Total usage transactions: " + Stuff.totalUse);
        }
        else {
            System.out.println("Item not found");
        }
    }
}
