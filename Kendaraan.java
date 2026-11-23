public class Kendaraan {
    private String platNomor;
    private String merk;
    private String jenis;
    private String keluhan;

    public Kendaraan(String platNomor, String merk, String jenis, String keluhan) {
        this.platNomor = platNomor;
        this.merk = merk;
        this.jenis = jenis;
        this.keluhan = keluhan;
    }

    public String getPlatNomor() { return platNomor; }
    public String getMerk()      { return merk; }
    public String getJenis()     { return jenis; }
    public String getKeluhan()   { return keluhan; }

    public String info() {
        return platNomor + " | " + merk + " | " + jenis + " | Keluhan: " + keluhan;
    }
}
