//Nama: Aprillia Wulandari
//NIM : L0124040

//import class Scanner dari package java.util
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //objek Scanner untuk input
        Scanner sc = new Scanner(System.in);
        //objek inventory untuk daftar barang
        Inventory items = new Inventory();

        //menu utama
        while (true) {
            System.out.println("====================================");
            System.out.println("         OFFICE INVENTORY MENU      ");
            System.out.println("====================================");
            System.out.println("            [1] Add Stock           ");
            System.out.println("            [2] Withdraw Item       ");
            System.out.println("            [3] Item List           ");
            System.out.println("            [4] Exit                ");
            System.out.println("------------------------------------");
            System.out.print("Input Option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Item name: ");
                    String name = sc.nextLine();
                    System.out.print("Total: ");
                    int total = sc.nextInt();
                    sc.nextLine();
                    items.tambahStok(name, total);

                    break;

                case 2:
                    System.out.print("Item name: ");
                    String nameUse = sc.nextLine();
                    System.out.print("Total: ");
                    int totalUse = sc.nextInt();
                    sc.nextLine();
                    items.pakaiBarang(nameUse, totalUse);

                    break;

                case 3:
                    System.out.printf("%-15s | %-15s | %-5s | %-10s | %-12s\n", 
                    "Name", "Category", "Stock", "Price", "Total Inventatory");
                    System.out.println("--------------------------------------------------------------------------");
                    for (Stuff s: items.getItems()) {
                        s.display();
                    }
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("Total transaksi used: " + Stuff.totalUse);
                    break;
                
                case 4:
                    System.out.println("Thanks");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please input again");
                    break;
            }
        }
    }
}
