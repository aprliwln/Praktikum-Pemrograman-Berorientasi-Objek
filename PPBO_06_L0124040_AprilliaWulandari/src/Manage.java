import java.util.*;

public class Manage {
    
    //array static
    public static void display() {
        //untuk menambahkan data mahasiswa baru dengan array statis 
        Mahasiswa[] mahasiswa = {
            new Mahasiswa("L0124040", "April", 88),
            new Mahasiswa("L0124041", "Ardina", 83),
            new Mahasiswa("L0124049", "Erika", 89),
            new Mahasiswa("L0124059", "Yasmin", 83),
            new Mahasiswa("L0124044", "Jeff", 90)
        };

        System.out.println("====================================");
        System.out.println("    DATA MAHASISWA (ARRAY STATIC)   ");
        System.out.println("====================================");
        System.out.printf("%-10s | %-10s | %-8s\n", "NIM", "Nama", "Nilai");
        System.out.println("------------------------------------");
        for (Mahasiswa m: mahasiswa) {
            System.out.printf("%-10s | %-10s | %-8d\n", m.getNIM(), m.getNama(), m.getNilai());
        }
        System.out.println();
    }

    //Collection Framework
    public static void collection() {

        //untuk menambahkan data mahasiswa baru dgn arraylist dynmaic data
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        listMahasiswa.add(new Mahasiswa("L0124079", "Trisa", 90));
        listMahasiswa.add(new Mahasiswa("L0124075", "Sanny", 95));
        listMahasiswa.add(new Mahasiswa("L0124076", "Saskya", 85));
        listMahasiswa.add(new Mahasiswa("L0124071", "Rifqia", 89));
        listMahasiswa.add(new Mahasiswa("L0124067", "Naomi", 85));
        
        System.out.println("====================================");
        System.out.println(" DATA MAHASISWA (ARRAY LIST DYNAMIC)");
        System.out.println("====================================");
        System.out.printf("%-10s | %-10s | %-8s\n", "NIM", "Nama", "Nilai");
        System.out.println("------------------------------------");
        for (Mahasiswa m: listMahasiswa) {
            System.out.printf("%-10s | %-10s | %-8d\n", m.getNIM(), m.getNama(), m.getNilai());
        }
        System.out.println("------------------------------------");
        System.out.println(); //untuk newline

        //collections sort digunakan untuk mengurutkan nama mahasiswa berdasarkan abjad nama
        Collections.sort(listMahasiswa, new Comparator<Mahasiswa>() {
            //fungsi untuk membandingkan nama mahasiswa
            public int compare (Mahasiswa m1, Mahasiswa m2) {
                return m1.getNama().compareToIgnoreCase(m2.getNama());
            }
        });

        //perulangan untuk menghapus NIM = L0124071
        for (int i = 0; i < listMahasiswa.size(); i++) {
            if (listMahasiswa.get(i).getNIM().equals("L0124071")) {
                listMahasiswa.remove(i);
                break;
            }
        }

        System.out.println("------------------------------------");
        System.out.println("      DATA MAHASISWA (SORT)      ");
        System.out.println("------------------------------------");
        System.out.printf("%-10s | %-10s | %-8s\n", "NIM", "Nama", "Nilai");
        System.out.println("------------------------------------");
        for (Mahasiswa m: listMahasiswa) {
            System.out.printf("%-10s | %-10s | %-8d\n", m.getNIM(), m.getNama(), m.getNilai());
        }
        System.out.println("------------------------------------");
        System.out.println("NIM L0124071 has been removed");
        System.out.println();

        //HashSet digunakan untuk menyimpan daftar nama mahasiswa tanpa duplikasi 
        HashSet<String> uniqueName = new HashSet<>();
        for (int i = 0; i < listMahasiswa.size(); i++){
            uniqueName.add(listMahasiswa.get(i).getNama());
        }

        System.out.println("------------------------------------");
        System.out.println("      NAMA UNIK (HASHSET)      ");
        System.out.println("------------------------------------");
        for (String name: uniqueName) {
            System.out.println(name);
        }
        System.out.println("------------------------------------");
        System.out.println();

        //Hashmap untuk memetakan NIM sebagai key dan Nilai sebagai value
        HashMap<String, Integer> mapValue = new HashMap<>();
        mapValue.put("L0124075", 90);
        mapValue.put("L0124079", 95);
        mapValue.put("L0124067", 85);

        System.out.println("------------------------------------");
        System.out.println("  NILAI MAHASISWA (HASHMAP)     ");
        System.out.println("------------------------------------");
        System.out.printf("%-10s | %-8s\n", "NIM", "Nilai");
        System.out.println("------------------------------------");

        int total = 0; //inisialisasi nilai total awal 0
        for (String nim: mapValue.keySet()) {
            int value = mapValue.get(nim);
            System.out.printf("%-10s | %-8d\n", nim, value);
            total += value; //nilai ditambahkan
        }
        System.out.println("------------------------------------");
        System.out.println("Rata-rata nilai: " + (total / mapValue.size()));
        System.out.println();

        //LinkedList digunakan untuk menambahkan data mahasiswa secara dinamis
        LinkedList<Mahasiswa> linkedListMhs = new LinkedList<>();
        linkedListMhs.add(new Mahasiswa("L0124042", "Bagas", 89));
        linkedListMhs.add(new Mahasiswa("L0124043", "Hakim", 93));
        linkedListMhs.add(new Mahasiswa("L0124085", "Aisyah", 81));
        linkedListMhs.add(new Mahasiswa("L0124092", "Calista", 80));
        System.out.println("====================================");
        System.out.println("    DATA MAHASISWA (LINKED LIST)    ");
        System.out.println("====================================");
        System.out.printf("%-10s | %-10s | %-8s\n", "NIM", "Nama", "Nilai");
        System.out.println("------------------------------------");
        for(Mahasiswa m: linkedListMhs) {
            System.out.printf("%-10s | %-10s | %-8d\n", m.getNIM(), m.getNama(), m.getNilai());
        }
        System.out.println("------------------------------------");
    }
}
