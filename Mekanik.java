public class Mekanik {
    private int idMekanik;
    private String nama;
    private String keahlian;
    private boolean tersedia;

    public Mekanik(int idMekanik, String nama, String keahlian) {
        this.idMekanik = idMekanik;
        this.nama = nama;
        this.keahlian = keahlian;
        this.tersedia = true;
    }

    public int getIdMekanik()   { return idMekanik; }
    public String getNama()     { return nama; }
    public String getKeahlian() { return keahlian; }
    public boolean isTersedia() { return tersedia; }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public String info() {
        return "ID " + idMekanik + " | " + nama + " | " + keahlian
                + " | " + (tersedia ? "Tersedia" : "Sedang bekerja");
    }
}
