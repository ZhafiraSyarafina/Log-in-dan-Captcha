// Kelas Pelanggan kelas turunan
class Pelanggan {
    private String namaPelanggan;
    private String noHP;
    private String alamat;

    // Constructor
    public Pelanggan(String namaPelanggan, String noHP, String alamat) {
        this.namaPelanggan = namaPelanggan;
        this.noHP = noHP;
        this.alamat = alamat;
    }

    // Override untuk representasi string objek
    @Override
    public String toString() {
        return "DATA PELANGGAN\n---------------------\n" +
               "Nama Pelanggan : " + namaPelanggan + "\n" +
               "No. HP         : " + noHP + "\n" +
               "Alamat         : " + alamat + "\n" +
               "++++++++++++++++++++++++";
    }
}