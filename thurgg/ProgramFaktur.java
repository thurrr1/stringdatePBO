import java.time.LocalDateTime;
import java.util.Scanner; 
//import scanner agar bisa melakukan input data 
public class ProgramFaktur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "Fathur";
        String password = "andalaspadang";
        boolean login = true;

        try {
            // Login
            while (login) {
                System.out.print("Masukkan Username: ");
                String inputUsername = scanner.nextLine();
                System.out.print("Masukkan Password: ");
                String inputPassword = scanner.nextLine();
                System.out.println("....oOo..oOo...oOo......oOo...oOo...");
                System.out.print("Captcha: Berapa banyak 'oOo' di atas?: ");
                int captchaInput = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (username.equals(inputUsername) && password.equals(inputPassword) && captchaInput == 5) {
                    login = false;
                    System.out.println("Login berhasil");
                } else {
                    System.out.println("Login gagal! Coba lagi.\n");
                }
            }
            System.out.println("----------------------------------------------");
            System.out.println("Selamat datang di Thurmaret");
            LocalDateTime waktuSekarang = LocalDateTime.now();
            System.out.println("Tanggal dan waktu sekarang: " + waktuSekarang);
            System.out.println("----------------------------------------------");

            // Input data faktur
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            double hargaBarang = 0;
            while (hargaBarang <= 0) {
                System.out.print("Masukkan Harga Barang: ");
                hargaBarang = scanner.nextDouble();
                if (hargaBarang <= 0) {
                    System.out.println("Harga barang harus lebih dari 0!");
                }
            }

            int jumlahBeli = 0;
            while (jumlahBeli <= 0) {
                System.out.print("Masukkan Jumlah Beli: ");
                jumlahBeli = scanner.nextInt();
                if (jumlahBeli <= 0) {
                    System.out.println("Jumlah beli harus lebih dari 0!");
                }
            }
            System.out.println("----------------------------------------------");

            // Membuat objek Faktur
            Faktur faktur = new Faktur(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan faktur
            System.out.println("\n--- Detail Faktur Pembelian ---");
            faktur.tampilkanFaktur();
            System.out.println("----------------------------------------------");
            System.out.println("Kasir: " + username);
            System.out.println("----------------------------------------------\n");

        } finally {
            scanner.close();
        }
    }
}
