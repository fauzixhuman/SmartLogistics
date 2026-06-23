package model;

public class Pengiriman {
    private String kotaAsal;
    private String kotaTujuan;
    private String jenisPengiriman;
    private double berat;
    private double jarakRute;
    private String segmenPelanggan;

    public Pengiriman(String kotaAsal, String kotaTujuan, String jenisPengiriman, double berat, double jarakRute, String segmenPelanggan) {
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.jenisPengiriman = jenisPengiriman;
        this.berat = berat;
        this.jarakRute = jarakRute;
        this.segmenPelanggan = segmenPelanggan;
    }

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public String getKotaTujuan() {
        return kotaTujuan;
    }

    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    public String getJenisPengiriman() {
        return jenisPengiriman;
    }

    public void setJenisPengiriman(String jenisPengiriman) {
        this.jenisPengiriman = jenisPengiriman;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public double getJarakRute() {
        return jarakRute;
    }

    public void setJarakRute(double jarakRute) {
        this.jarakRute = jarakRute;
    }

    public String getSegmenPelanggan() {
        return segmenPelanggan;
    }

    public void setSegmenPelanggan(String segmenPelanggan) {
        this.segmenPelanggan = segmenPelanggan;
    }
}
