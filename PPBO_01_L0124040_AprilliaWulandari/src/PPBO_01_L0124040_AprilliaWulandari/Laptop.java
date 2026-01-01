//package
package PPBO_01_L0124040_AprilliaWulandari;

//class
public class Laptop {
    String name;
    String brand;
    String os;
    String cpu;
    String gpu;
    int ram;
    int storage;

    //constructor
    public Laptop (String name, String brand, String os, String cpu, 
                    String gpu, int ram, int storage) {
        this.name = name;
        this.brand = brand;
        this.os = os;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
    }

    //method
    public void display(){
        System.out.println("====================================");
        System.out.println(" SPESIFIKASI " + name);
        System.out.println("====================================");
        System.out.println("Brand\t: " + brand);
        System.out.println("OS\t: " + os);
        System.out.println("CPU\t: " + cpu);
        System.out.println("GPU\t: " + gpu);
        System.out.println("RAM\t: " + ram + " GB");
        System.out.println("Storage\t: " + storage + " GB");
    }
}
