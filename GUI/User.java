interface ZodiacCalculator {
    String determineZodiac();
}

public class User extends Person implements ZodiacCalculator {

    public User(String nama, int tanggal, int bulan) {
        super(nama, tanggal, bulan);
    }   

    @Override
    public String determineZodiac() {
        if ((bulan == 3 && tanggal >= 21) || (bulan == 4 && tanggal <= 19)) return "Aries";
        if ((bulan == 4 && tanggal >= 20) || (bulan == 5 && tanggal <= 20)) return "Taurus";
        if ((bulan == 5 && tanggal >= 21) || (bulan == 6 && tanggal <= 20)) return "Gemini";
        if ((bulan == 6 && tanggal >= 21) || (bulan == 7 && tanggal <= 22)) return "Cancer";
        if ((bulan == 7 && tanggal >= 23) || (bulan == 8 && tanggal <= 22)) return "Leo";
        if ((bulan == 8 && tanggal >= 23) || (bulan == 9 && tanggal <= 22)) return "Virgo";
        if ((bulan == 9 && tanggal >= 23) || (bulan == 10 && tanggal <= 22)) return "Libra";
        if ((bulan == 10 && tanggal >= 23) || (bulan == 11 && tanggal <= 21)) return "Scorpio";
        if ((bulan == 11 && tanggal >= 22) || (bulan == 12 && tanggal <= 21)) return "Sagitarius";
        if ((bulan == 12 && tanggal >= 22) || (bulan == 1 && tanggal <= 19)) return "Capricorn";
        if ((bulan == 1 && tanggal >= 20) || (bulan == 2 && tanggal <= 18)) return "Aquarius";
        return "Pisces"; //if ((bulan == 2 && tanggal >= 19) || (bulan == 3 && tanggal <= 20))
    }

    @Override
    public String greeting() {
        String bintang = determineZodiac();
        return "Halo " + nama + ", bintang kamu adalah " + bintang;
    }
}