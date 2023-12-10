import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Kelas utama yang berisi metode main
public class Minimarket {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    private static final String CAPTCHA = "VisualStudioCode"; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loginSuccessful = false;
        boolean inputValid = false;
       
    do {    
        // Login
        System.out.println("=== LOGIN ===");
        if (login(scanner)) {
        // captcha
            String generatedCaptcha = generateCaptcha();
            System.out.println("Captcha: " + generatedCaptcha);
        
            // Valid captcha
            if (validateCaptcha(scanner, generatedCaptcha)) {
                loginSuccessful = true;
            } else {
                System.out.println("Captcha salah. Silakan login kembali.");
            }
        } else {
            System.out.println("Username atau password salah. Silakan login kembali.");
        }
    } while (!loginSuccessful);

    do{
        try{
        // Membuat objek SimpleDateFormat untuk format tanggal dan waktu
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss z");

        // Mendapatkan tanggal dan waktu saat ini
        Date currentDate = new Date();

        // Menampilkan informasi header
        System.out.println("\n===MINIMARKET===");
        System.out.println("Tanggal : " + dateFormat.format(currentDate));
        System.out.println("Waktu   : " + timeFormat.format(currentDate));
        System.out.println("========================");

        // Input data pelanggan
        DataPelanggan dataPelanggan = inputDataPelanggan();

        // Input data pembelian barang
        DataPembelian dataPembelian = inputDataPembelian();

        // Menampilkan semua data yang telah diinput
        System.out.println(dataPelanggan.toString());
        System.out.println(dataPembelian.toString());

        // Menampilkan kasir (sebagai contoh, kita masukkan kasir "John Doe")
        System.out.println("Kasir    : Dea");
    
        inputValid = true;
    } catch (Exception e) {
    System.out.println("Terjadi kesalahan       : " + e.getMessage() + "\n");
    scanner.nextLine(); // Membersihkan newline 
    }
} while (!inputValid);

scanner.close(); // Menutup scanner apabila telah benar atau valid
}

private static boolean login(Scanner scanner) {
    System.out.print("Username: ");
    String enteredUsername = scanner.nextLine();
    System.out.print("Password: ");
    String enteredPassword = scanner.nextLine();
    return USERNAME.equals(enteredUsername) && PASSWORD.equals(enteredPassword);
}

private static String generateCaptcha() {
    // string acak captcha
    return CAPTCHA;
}

private static boolean validateCaptcha(Scanner scanner, String generatedCaptcha) {
    System.out.print("Masukkan Captcha: ");
    String enteredCaptcha = scanner.nextLine();
    return generatedCaptcha.equalsIgnoreCase(enteredCaptcha);
}

    // Metode untuk input data pelanggan
    private static DataPelanggan inputDataPelanggan() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Pelanggan : ");
        String namaPelanggan = scanner.nextLine();

        System.out.print("No. HP         : ");
        String noHP = scanner.nextLine();

        System.out.print("Alamat         : ");
        String alamat = scanner.nextLine();

        return new DataPelanggan(namaPelanggan, noHP, alamat);
    }

    // Metode untuk input data pembelian
    private static DataPembelian inputDataPembelian() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kode Barang    : ");
        String kodeBarang = scanner.nextLine();

        System.out.print("Nama Barang    : ");
        String namaBarang = scanner.nextLine();

        System.out.print("Harga Barang   : ");
        double hargaBarang = scanner.nextDouble();

        System.out.print("Jumlah Beli    : ");
        int jumlahBeli = scanner.nextInt();

        return new DataPembelian(kodeBarang, namaBarang, hargaBarang, jumlahBeli);
    }
}

