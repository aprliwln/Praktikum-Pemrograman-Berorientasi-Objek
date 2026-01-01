public class Validation {

    //validasi untuk format tanggal lahir menggunakan regrex
    public static boolean valDate (String dateOfBirth) {
        String pattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        return dateOfBirth.matches(pattern); //format (dd/mm/yyyy)
    }

    //validasi untuk format nomer telepon, harus + atau 00 di awal
    //kemudian diikuti kode negara
    public static boolean valNomor (String nomor) {
        String pattern = "^(\\+|00)\\d{10,15}$";
        return nomor.matches(pattern);
    }

    //validasi untuk format email
    public static boolean valEmail (String email) {
        String pattern = "^[A-Za-z0-9][A-Za-z0-9._-]{5,50}@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(pattern);
    }
}
