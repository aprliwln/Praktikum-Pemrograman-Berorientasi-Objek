/*
Nama: Aprillia Wulandari
NIM : L0124040 
*/

import java.util.*; //digunakan utk kelas Date
import java.text.*; //digunka utk simple date format

public class Main {
    public static void main(String[] args) throws Exception {
        //membuat nama file berdasarkan tanggal hari ini
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String fileName = date + ".txt";

        //membuat objek ActivityManager
        ActivityManager manage = new ActivityManager(fileName);
        manage.menu(); //menjalankan menu utama
    }
}
