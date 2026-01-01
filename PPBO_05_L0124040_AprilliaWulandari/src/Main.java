/*
Nama: Aprillia Wulandari
NIM : L0124040
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            //selama kondisi benar atau tidak memasukkan 3, maka akan terus mengulang
            System.out.println("====================================");
            System.out.println("         KAI ACCOUNT SYSTEM         ");
            System.out.println("====================================");
            System.out.println("       [1] Login            ");
            System.out.println("       [2] Register     ");
            System.out.println("       [3] Exit          ");
            System.out.println("------------------------------------");
            System.out.print("Input option: ");
            int option = sc.nextInt();
            sc.nextLine();

            //case akan berjalan sesuai dengan input user
            switch (option) {
                case 1:
                    System.out.print("Full Name\t\t: ");
                    String name = sc.nextLine();

                    //validasi jika huruf pertama nama tidak menggunakan huruf besar
                    if (!Character.isUpperCase(name.charAt(0))) {
                        System.out.println("The first letter must be uppercase");
                        break;
                    }

                    System.out.print("Phone Number (+ or 00)\t: ");
                    String nomor = sc.nextLine();

                    //validasi jika nomer yang dimasukkan tidak sesuai format
                    if (!Validation.valNomor(nomor)) {
                        System.out.println("Invalid phone number format");
                        break;
                    }
                    
                    //akun yang dimasukkan akan dicari terlebih dahulu
                    Passenger p = Passenger.findPassenger(name, nomor);
                    //validasi akun jika ditemukan
                    if (p != null) {
                        System.out.println("Welcome back " + p.name);
                    }
                    else { //jika tidak
                        System.out.println("Account not found. Please register first");
                    }
                    break;
                case 2:
                    System.out.println("------------------------------------");
                    System.out.println("      KAI ACCOUNT REGISTRATION      ");
                    System.out.println("------------------------------------");

                    System.out.print("Full Name\t\t: ");
                    String nameReg = sc.nextLine();
                    //validasi jika huruf pertama nama tidak menggunakan huruf besar
                    if (!Character.isUpperCase(nameReg.charAt(0))) {
                        System.out.println("The first letter must be uppercase");
                        break;
                    }

                    System.out.print("Date of Birth (dd/mm/yyyy):  ");
                    String date = sc.nextLine();
                    //validasi jika tgl lahir yang dimasukkan tdk sesuai format
                    if (!Validation.valDate(date)) {
                        System.out.println("Invalid Date of Birth format");
                        break;
                    }
                    else {
                        System.out.println("Date of birth valid");
                    }

                    System.out.print("Number Phone (+ or 00)\t: ");
                    String nomorReg = sc.nextLine();
                    //validasi jika nomer telpon yg dimasukkan tdk sesuai format
                    if (!Validation.valNomor(nomorReg)) {
                        System.out.println("Invalid number phone format");
                        break;
                    }
                    else {
                        System.out.println("Phone number valid");
                    }

                    System.out.print("Email\t\t\t: ");
                    String email = sc.nextLine();
                    //validasi jika email yang dimasukkan tdk sesuai format
                    if (!Validation.valEmail(email)) {
                        System.out.println("Invalid email address format");
                        break;
                    }
                    else {
                        System.out.println("Email address valid");
                    }

                    //untuk mengecek jika akun sudah ada
                    Passenger exist = Passenger.findPassenger(nameReg, nomorReg);
                    if (exist != null) {
                        System.out.println("Account already exists. Please login instead");
                        break;
                    }

                    //jika belum, maka akun baru akan disimpan
                    Passenger.listPassengers.add(new Passenger(nameReg, date, nomorReg, email));
                    System.out.println("Successfully registered! You can login now!");
                    break;
                case 3:
                    System.out.println("Thank you for using the KAI Account System");
                    sc.close(); //tutup scanner
                    return;
                default:
                    System.out.println("Invalid option. Please try again");
                    break;
            }
        }
    }
}