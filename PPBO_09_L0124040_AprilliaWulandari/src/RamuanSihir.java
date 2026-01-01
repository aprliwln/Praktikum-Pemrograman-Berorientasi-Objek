public class RamuanSihir {
    //atribut superclass
    protected String nama;                  //menyimpan nama ramuan
    protected int tingkatKesulitan;         //tingkat kesulitan pembuatan ramuan
    protected double volumeMl;              //volume ramuan dalam mililiter
    protected boolean status;               //status legal ramuan

    //constructor utk menginisialisasi semua atribut
    public RamuanSihir (String nama, int tingkatKesulitan, double volumeMl, boolean status) {
        this.nama = nama;
        this.tingkatKesulitan = tingkatKesulitan;
        this.volumeMl = volumeMl;
        this.status = status;
    }

    //method untuk menampilkan informasi umum ramuan
    public void tampilkanInfo() {
        System.out.println("Nama Ramuan\t\t: " + nama);
        System.out.println("Tingkat Kesulitan\t: " + tingkatKesulitan);
        System.out.println("Volume (ml)\t\t: " + volumeMl);

        //menampilkan status legal 
        if (status == true) {
            System.out.println("\u001B[32mLegal di Kementerian Sihir\u001B[0m");
        }
        else {
            System.out.println("\u001B[31mTidak Legal di Kementerian Sihir\u001B[0m");
        }
    }

    //method tambahan untuk aksi unik superclass
    public void adukRamuan() {
        System.out.println("\u001B[35mMengaduk ramuan \u001B[33m" + nama + "\u001B[0m \u001B[35mdengan sendok perak antik...\u001B[0m");
    }
}
