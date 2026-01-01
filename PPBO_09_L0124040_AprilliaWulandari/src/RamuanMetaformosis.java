public class RamuanMetaformosis extends RamuanSihir{
    //atribut tambahan utk subclass
    private String bentukTransfor; //bentuk transformasi yang dihasilkan ramuan
    private int durasiEfek;        //durasi efek transformasi

    //constructor subclass
    public RamuanMetaformosis (String nama, int tingkatKesulitan, double volumeMl, 
                                boolean status, String bentukTransfor, int durasiEfek) {
        super(nama, tingkatKesulitan, volumeMl, status); //memanggil constructor superclass
        this.bentukTransfor = bentukTransfor;
        this.durasiEfek = durasiEfek;
    }

    //method unik subclass untuk mengaktifkan mantra
    public void aktifkanMantra() {
        System.out.println("\u001B[34mMantra diaktifkan! Tubuhmu berubah menjadi \u001B[36m" + bentukTransfor + 
                        "\u001B[0m \u001B[34mselama \u001B[36m" + durasiEfek + "\u001B[0m \u001B[34mmenit\u001B[0m");
    }

    //method untuk menampilkan informasi detail ramuan
    public void tampilkanDetailRamuan() {
        tampilkanInfo(); //memanggil method superclass
        System.out.println("Bentuk Transformasi\t: " + bentukTransfor);
        System.out.println("Durasi Efek\t\t: " + durasiEfek + " menit");
        System.out.println("------------------------------------------");
    }
}
