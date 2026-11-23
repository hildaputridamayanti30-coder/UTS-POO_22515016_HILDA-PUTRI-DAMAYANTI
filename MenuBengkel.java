import java.util.Scanner;

public class MenuBengkel {
    private Bengkel bengkel;
    private Scanner input;

    public MenuBengkel() {
        this.bengkel = new Bengkel("Bengkel Maju Jaya");
        this.input = new Scanner(System.in);
    }

    public void tampilMenu() {
        System.out.println("\n=== " + bengkel.getNama() + " ===");
        System.out.println("1. Tambah kendaraan");
        System.out.println("2. Tambah mekanik");
        System.out.println("3. Lihat kendaraan");
        System.out.println("4. Lihat mekanik");
        System.out.println("5. Buat servis");
        System.out.println("6. Selesaikan servis terakhir");
        System.out.println("7. Lihat riwayat servis (terbaru dulu)");
        System.out.println("8. Batalkan servis terakhir");
        System.out.println("0. Keluar");
        System.out.print("Pilih: ");
    }

    private String baca(String label) {
        System.out.print(label + ": ");
        return input.nextLine().trim();
    }

    private int bacaAngka(String label) {
        try {
            return Integer.parseInt(baca(label));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void prosesPilihan(int pilihan) {
        switch (pilihan) {
            case 1:
                String plat = baca("Plat nomor");
                String merk = baca("Merk");
                String jenis = baca("Jenis (Motor/Mobil/lainnya)");
                String keluhan = baca("Keluhan");
                bengkel.tambahKendaraan(new Kendaraan(plat, merk, jenis, keluhan));
                break;
            case 2:
                String nama = baca("Nama mekanik");
                String keahlian = baca("Keahlian");
                bengkel.tambahMekanik(new Mekanik(bengkel.jumlahMekanik() + 1, nama, keahlian));
                break;
            case 3:
                bengkel.tampilKendaraan();
                break;
            case 4:
                bengkel.tampilMekanik();
                break;
            case 5:
                String p = baca("Plat nomor kendaraan");
                int id = bacaAngka("ID mekanik");
                bengkel.buatServis(p, id);
                break;
            case 6:
                bengkel.selesaikanServisTerakhir();
                break;
            case 7:
                bengkel.lihatRiwayat();
                break;
            case 8:
                bengkel.batalkanServisTerakhir();
                break;
            case 0:
                System.out.println("Terima kasih!");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    public void jalankan() {
        int pilihan = -1;
        while (pilihan != 0) {
            tampilMenu();
            try {
                pilihan = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                pilihan = -1;
            }
            prosesPilihan(pilihan);
        }
    }

    public static void main(String[] args) {
        new MenuBengkel().jalankan();
    }
}
