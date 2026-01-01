import java.util.*; //digunakan utk Scanner, ArrayList
import java.io.*; //digunakan utk operasi I/O file
import java.text.*; //digunkan utk format waktu

public class ActivityManager {
    private Scanner sc = new Scanner(System.in); //membaca input user
    private ArrayList<Activity> listActivities = new ArrayList<>(); //menyimpan daftar aktivitas
    private String fileName; //menyimpan nama file utk data

    //constructor
    public ActivityManager (String fileName) {
        this.fileName = fileName;
        readFile(); //membaca isi file
    }
    
    //method utk membaca data dari file jika sudah ada filenya
    private void readFile() {
        File file = new File(fileName); //membuat objek file brdsrkan nama yg ditentukan
        if (file.exists()) { //jika file sudah ada, maka hanya dibaca
            try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("\\|"); //pisahkan tiap data berdasarkan simbol '|'
                    if (data.length == 3) {
                        //tambahkan ke list aktivitas
                        listActivities.add(new Activity(data[0], data[1], data[2]));
                    }
                }
            } catch (IOException e) {
                System.out.println("Failed to read the file: " + e.getMessage());
            }
        }
    }

    //method utk menulis seluruh data aktivitas ke file
    private void writeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (Activity a: listActivities) {
                writer.write(a.getTime() + "|" + a.getName() + "|" + a.getDescription());
                writer.newLine(); //pindah baris setelah setiap data ditulis
            }
            System.out.println("Data has been successfully saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save data: " + e.getMessage());
        }
    }

    //method utk menambah aktivitas baru ke dalam list
    private void addActivity() {
        int total;
        //validasi input jumlah aktivitas
        while (true) {
            try {
                System.out.print("Input total activities: ");
                total = Integer.parseInt(sc.nextLine());
                if (total > 0) break; //jika valid keluar dari loop
                //jika angka yg dimasukkan negatif
                System.out.println("Please input a positive number");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number");
            }
        }

        //loop untuk input setiap aktivitas
        for (int i = 0; i < total; i++) {
            System.out.println("\nActivity " + (i+1));

            //validasi waktu
            String time;
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            sdf.setLenient(false); //memastikan waktu harus valid (25:00 tdk boleh)
            while (true) {
                System.out.print("Time (HH:mm)\t: ");
                time = sc.nextLine().trim();
                try {
                    sdf.parse(time); //cek apakah formatnya valid
                    break;
                } catch (ParseException e) {
                    System.out.println("Invalid time format. Use HH:mm");
                }
            }
            
            //validasi nama aktivitas
            String name;
            while (true) {
                System.out.print("Activity name\t: ");
                name = sc.nextLine().trim();
                if (!name.isEmpty()) break; //jika nama dimasukkan
                //jika nama tidak dimasukkan (kosong)
                System.out.println("Activity name cannot be empty");
            }

            //validasi deskripsi
            String description;
            while (true) {
                System.out.print("Description\t: ");
                description = sc.nextLine().trim();
                if (!description.isEmpty()) break; //jika deskripsi dimasukkan
                //jika deskripsi tidak dimasukkan (kosong)
                System.out.println("Description cannot be empty");
            }

            //tambahkan aktivitas baru ke dalam daftar
            listActivities.add(new Activity(time, name, description));
        }
        //simpan data baru ke file
        writeFile();
    }

    //method utk menampilkan daftar aktivitas hari ini
    private void displayActivites() {
        //jika daftar aktivitas kosong
        if (listActivities.isEmpty()) {
            System.out.println("No activities scheduled for today");
        }
        //jika tidak kosong
        else {
            System.out.println("==============================================================");
            System.out.println("                     TODAY'S ACTIVITIES LIST                  ");
            System.out.println("--------------------------------------------------------------");
            System.out.printf("%-10s | %-20s | %-30s\n", "Time", "Activity", "Description");
            System.out.println("--------------------------------------------------------------");
            for (Activity a: listActivities) {
                a.display();
            }
        }
    }

    //method utk menampilkan menu utama
    public void menu() {
        while (true) {
            System.out.println("====================================");
            System.out.println("            ACTIVITY MENU           ");
            System.out.println("====================================");
            System.out.println("       [1] Add Today's Activity     ");
            System.out.println("       [2] View Today's Activity    ");
            System.out.println("       [3] Exit          ");
            System.out.println("------------------------------------");
            System.out.print("Input option: ");
            int option = sc.nextInt();
            sc.nextLine(); //menghapus newline
            
            //menentukan aksi berdasarkan input user
            switch (option) {
                case 1:
                    addActivity();
                    break;
                case 2:
                    displayActivites();
                    break;
                case 3:
                    System.out.println("Thank you for trying this program");
                    sc.close(); //menutup scanner
                    return;
                default:
                    System.out.println("Invalid option. Please try again");
                    break;
            }
        }
    }
}