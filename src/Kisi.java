public class Kisi {

    private String adSoyad ="";
    private String dogumTarihi="";

    public Kisi() {
    }

    public Kisi(String adSoyad, String dogumTarihi) {
        this.adSoyad = adSoyad;
        this.dogumTarihi = dogumTarihi;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "adSoyad='" + adSoyad + '\'' +
                ", dogumTarihi='" + dogumTarihi + '\'' +
                '}'+"\n";
    }
}
