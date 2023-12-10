// Kelas Faktur yang menerapkan interface Barang
class Faktur implements Barang {
    private String noFaktur;
    private Barang barang;
    private Pelanggan pelanggan;

    // Constructor
    public Faktur(String noFaktur, Barang barang, Pelanggan pelanggan) {
        this.noFaktur = noFaktur;
        this.barang = barang;
        this.pelanggan = pelanggan;
    }

    // Implementasi hitungTotal() dari interface Barang
    @Override
    public double hitungTotal() {
        return barang.hitungTotal();
    }

    // Override untuk representasi string objek
    @Override
    public String toString() {
        return "No Faktur      : " + noFaktur + "\n" +
               pelanggan.toString() + "\n" +
               barang.toString() + "\n" +
               "Total Bayar   : " + hitungTotal() + "\n" +
               "++++++++++++++++++++++++";
    }
}
