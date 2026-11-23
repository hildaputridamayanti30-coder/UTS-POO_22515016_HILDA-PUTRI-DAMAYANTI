public class Servis {
    private int idServis;
    private Kendaraan kendaraan;
    private Mekanik mekanik;
    private double biaya;
    private String status;

    public Servis(int idServis, Kendaraan kendaraan, Mekanik mekanik) {
        this.idServis = idServis;
        this.kendaraan = kendaraan;
        this.mekanik = mekanik;
        this.status = "Dikerjakan";
        this.biaya = hitungBiaya();
    }

    // Biaya dasar ditentukan dari jenis kendaraan
    public double hitungBiaya() {
        String jenis = kendaraan.getJenis().toLowerCase();
        if (jenis.equals("motor")) return 50000;
        if (jenis.equals("mobil")) return 150000;
        return 100000;
    }

    public void ubahStatus(String statusBaru) {
        this.status = statusBaru;
    }

    public int getIdServis()        { return idServis; }
    public Kendaraan getKendaraan() { return kendaraan; }
    public Mekanik getMekanik()     { return mekanik; }
    public double getBiaya()        { return biaya; }
    public String getStatus()       { return status; }

    public String info() {
        return "Servis #" + idServis
                + " | " + kendaraan.getPlatNomor() + " (" + kendaraan.getMerk() + ")"
                + " | Mekanik: " + mekanik.getNama()
                + " | Biaya: Rp" + String.format("%,.0f", biaya)
                + " | Status: " + status;
    }
}
