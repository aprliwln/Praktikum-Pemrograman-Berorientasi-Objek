/*
Nama    :Aprillia Wulandari
NIM     :L0124040
Kelas   :C 
*/

//package
import PPBO_01_L0124040_AprilliaWulandari.Laptop;

//class
public class Main {
    public static void main(String[] args) throws Exception {
        //object
        Laptop laptop1 = new Laptop("REDMIBOOK 15","Xiaomi", "Windows 10", 
                                    "Intel Core i3 1115G4", "Intel(R) UHD Graphics", 8, 256);
        Laptop laptop2 = new Laptop("Lenovo IDEAPAD GAMING 3", "Lenovo", "Windows 11", 
                                    "AMD Ryzen 5 5500H", "NIVIDIA GeForce RTX 2050", 8, 512);
        Laptop laptop3 = new Laptop("Macbook Air 13", "Apple", "macOS Big Sur", 
                                    "Apple M1", null, 8, 512);

        laptop1.display();
        laptop2.display();
        laptop3.display();
    }
}

