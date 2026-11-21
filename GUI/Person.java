public abstract class Person {
    protected String nama;
    protected int tanggal;
    protected int bulan;

    public Person(String nama, int tanggal, int bulan) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.bulan = bulan;
    }

    public String getNama() {
        return nama;
    }

    // Method abstral, wajib diisi enih nanti
    public abstract String greeting();
}