import java.util.Scanner;

public class Islemler implements IslemlerInterface {
    static Scanner scan = new Scanner(System.in);
    static int tercih = 0;
    static int scm = 0;

    public static void IslemlerMenu(int i) {

        Islemler obj = new Islemler();
        tercih = i;
        System.out.println("============= İŞLEMLER =============\n" +
                "\t\t 1-EKLEME\n" +
                "\t\t 2-ARAMA\n" +
                "\t\t 3-LİSTELEME\n" +
                "\t\t 4-SİLME\n" +
                "\t\t 5-ANA MENÜ\n" +
                "\t\t 6-ÇIKIŞ\n");

        System.out.println("Lutfen Secim yapiniz");
        try {

            scm = scan.nextInt();
            switch (scm) {
                case 1:
                    obj.ekleme();
                    IslemlerMenu(tercih);
                    break;
                case 2:
                    obj.arama();
                    IslemlerMenu(tercih);
                    break;
                case 3:
                    obj.listeleme();
                    IslemlerMenu(tercih);
                    break;
                case 4:
                    obj.silme();
                    IslemlerMenu(tercih);
                    break;
                case 5:
                    obj.anaMenu();
                    break;
                case 6:
                    obj.cikis();
                    break;
            }
        } catch (Exception e) {
            scan.nextLine();
            System.out.println("hatali giris yaptiniz");
            IslemlerMenu(i);
        }

    }

    @Override
    public void ekleme() {

        System.out.println("Kimlik numarasi giriniz:");
        String kimlikID = scan.next();
        kimlikIDKontrol(kimlikID);
        if (tercih == 1) {
            ogrenciBilgiAlKaydet(kimlikID);
        } else {
            ogretmenBilgiAlKaydet(kimlikID);
        }
    }

    private void ogretmenBilgiAlKaydet(String kimlikID) {

        System.out.println("Ad Soyad giriniz");
        scan.nextLine();
        String adSoyad = scan.nextLine();
        System.out.println("Dogum Yili giriniz");
        String dogumYili = scan.next();
        scan.nextLine();
        System.out.println("Bolum no giriniz");
        String bolum = scan.next();
        System.out.println("Sicil no giriniz");
        String sicilNo = scan.next();
        Ogretmen obj = new Ogretmen(adSoyad, dogumYili, bolum, sicilNo);
        Ogretmen.ogretmenListesiMap.put(kimlikID, obj);
    }

    private void ogrenciBilgiAlKaydet(String kimlikID) {

        System.out.println("Ad Soyad giriniz");
        scan.nextLine();
        String adSoyad = scan.nextLine();
        System.out.println("Dogum Yili giriniz");
        String dogumYili = scan.next();
        scan.nextLine();
        System.out.println("Numara giriniz");
        String numara = scan.next();
        System.out.println("Sinifi giriniz");
        String sinif = scan.next();
        Ogrenci obj = new Ogrenci(adSoyad, dogumYili, numara, sinif);
        Ogrenci.ogrenciListesiMap.put(kimlikID, obj);
    }

    private void kimlikIDKontrol(String kimlikID) {

        if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID) || Ogretmen.ogretmenListesiMap.containsKey(kimlikID)) {
            System.out.println("Bu ID kayit yapilmis ");
            AnaMenu.giris();
        }
    }

    @Override
    public void arama() {

        System.out.println("Kimlik numarasi girin");
        String kimlikID = scan.next();
        if (tercih == 1) {
            if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID)) {
                System.out.println(Ogrenci.ogrenciListesiMap.get(kimlikID));
            } else {
                System.out.println("kayitli degil");
            }
        } else if (tercih == 2) {
            if (Ogretmen.ogretmenListesiMap.containsKey(kimlikID)) {
                System.out.println(Ogretmen.ogretmenListesiMap.get(kimlikID));
            } else {
                System.out.println("kayitli degil");
            }
        }
    }

    @Override
    public void listeleme() {

        if (tercih == 1) {
            System.out.println(Ogrenci.ogrenciListesiMap);
        } else if (tercih == 2) {
            System.out.println(Ogretmen.ogretmenListesiMap);
        }
    }

    @Override
    public void silme() {

        System.out.println("Kimlik numarasi girin");
        String kimlikID = scan.next();
        if (tercih == 1) {
            if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID)) {
                Ogrenci.ogrenciListesiMap.remove(kimlikID);
            } else {
                System.out.println("kimlik ID mevcut degil");
            }
        } else if (tercih == 2) {
            if (Ogretmen.ogretmenListesiMap.containsKey(kimlikID)) {
                Ogretmen.ogretmenListesiMap.remove(kimlikID);
            } else {
                System.out.println("kimlik ID mevcut degil");
            }
        }
    }

    @Override
    public void anaMenu() {

        AnaMenu.giris();
    }

    @Override
    public void sifreDegistir() {
        System.out.println("Lutfen kullanici adinizi gırınız");
        String girilenKullaniciAdi = scan.nextLine();
        System.out.println("Lutfen guncel parolanizi giriniz");
        String guncelParola = scan.nextLine();
        if (girilenKullaniciAdi.equals(KullaniciGirisi.userName) && guncelParola.equals(KullaniciGirisi.parola)) {
            System.out.println("Lutfen yeni sifrenizi giriniz");
            KullaniciGirisi.parola = scan.nextLine();
            System.out.println("Parolaniz " + KullaniciGirisi.parola + " olarak guncellenmistir");
            AnaMenu.giris();
        } else {
            System.out.println("Kullanici adi ve parola hatali");
        }
    }

    @Override
    public void cikis() {

        System.out.println("gule gule");
    }
}
