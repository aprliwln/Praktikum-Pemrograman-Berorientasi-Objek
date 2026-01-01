public class Activity {
    private String time;        //menyimpan waktu
    private String name;        //menyimpan nama aktivitas
    private String description; //menyimpan deskripsi

    //constructor
    public Activity (String time, String name, String description) {
        this.time = time;
        this.name = name;
        this.description = description;
    }

    //getter
    public String getTime() {
        return time;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    //method utk menampilkan satu aktivitas
    public void display() {
        System.out.printf("%-10s | %-20s | %-30s\n", time, name, description);
    }
}
