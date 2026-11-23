import java.util.ArrayList;

public class Bengkel {
    private String nama;
    private ArrayList<Kendaraan> daftarKendaraan;
    private ArrayList<Mekanik> daftarMekanik;
    private Stack riwayat;
    private int counterServis;

    public Bengkel(String nama) {
        this.nama = nama;
        this.daftarKendaraan = new ArrayList<>();
        this.daftarMekanik = new ArrayList<>();
        this.riwayat = new Stack(50);
        this.counterServis = 0;
    }

    public String getNama() { return nama; }

    public void tambahKendaraan(Kendaraan k) {
        if (cariKendaraan(k.getPlatNomor()) != null) {
            System.out.println("Plat nomor sudah terdaftar.");
            return;
        }
        daftarKendaraan.add(k);
        System.out.println("Kendaraan berhasil ditambahkan.");
    }

    public void tambahMekanik(Mekanik m) {
        daftarMekanik.add(m);
        System.out.println("Mekanik berhasil ditambahkan (ID " + m.getIdMekanik() + ").");
    }

    public int jumlahMekanik() { return daftarMekanik.size(); }

    public Kendaraan cariKendaraan(String plat) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getPlatNomor().equalsIgnoreCase(plat)) return k;
        }
        return null;
    }

    public Mekanik cariMekanik(int id) {
        for (Mekanik m : daftarMekanik) {
            if (m.getIdMekanik() == id) return m;
        }
        return null;
    }

    public void tampilKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan.");
            return;
        }
        for (Kendaraan k : daftarKendaraan) System.out.println("- " + k.info());
    }

    public void tampilMekanik() {
        if (daftarMekanik.isEmpty()) {
            System.out.println("Belum ada mekanik.");
            return;
        }
        for (Mekanik m : daftarMekanik) System.out.println("- " + m.info());
    }

    public void buatServis(String plat, int idMekanik) {
        Kendaraan k = cariKendaraan(plat);
        Mekanik m = cariMekanik(idMekanik);

        if (k == null) { System.out.println("Kendaraan tidak ditemukan."); return; }
        if (m == null) { System.out.println("Mekanik tidak ditemukan."); return; }
        if (!m.isTersedia()) { System.out.println("Mekanik sedang mengerjakan servis lain."); return; }
        if (riwayat.isFull()) { System.out.println("Riwayat penuh."); return; }

        counterServis++;
        Servis s = new Servis(counterServis, k, m);
        m.setTersedia(false);
        riwayat.push(s);
        System.out.println("Servis dibuat: " + s.info());
    }

    public void selesaikanServisTerakhir() {
        Servis s = riwayat.peek();
        if (s == null) { System.out.println("Belum ada servis."); return; }
        if (s.getStatus().equals("Selesai")) {
            System.out.println("Servis terakhir sudah selesai.");
            return;
        }
        s.ubahStatus("Selesai");
        s.getMekanik().setTersedia(true);
        System.out.println("Servis selesai: " + s.info());
    }

    public void batalkanServisTerakhir() {
        Servis s = riwayat.pop();
        if (s == null) { System.out.println("Belum ada servis."); return; }
        if (s.getStatus().equals("Dikerjakan")) s.getMekanik().setTersedia(true);
        System.out.println("Servis dibatalkan: " + s.info());
    }

    // Tampilkan dari terbaru ke terlama dengan stack bantu, lalu kembalikan isinya
    public void lihatRiwayat() {
        if (riwayat.isEmpty()) {
            System.out.println("Riwayat servis kosong.");
            return;
        }
        Stack bantu = new Stack(50);
        while (!riwayat.isEmpty()) {
            Servis s = riwayat.pop();
            System.out.println("- " + s.info());
            bantu.push(s);
        }
        while (!bantu.isEmpty()) riwayat.push(bantu.pop());
    }
}
