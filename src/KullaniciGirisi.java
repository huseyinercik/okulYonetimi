import java.util.Scanner;

public class KullaniciGirisi implements KullaniciGirisiInterface{
    static Scanner scan = new Scanner(System.in);
    static final String userName = "huseyin.ercik";
    static String parola="Emir1234";
    @Override
    public void kullaniciGirisi() {
        String kullaniciAdi="";
        String kullaniciParola="";
        System.out.println("===================OKUL YONETIMINE HOSGELDINIZ==================");
        System.out.println("Lutfen kullanici adinizi giriniz");
        kullaniciAdi= scan.nextLine();
        System.out.println("Lutfen parolanizi giriniz");
        kullaniciParola=scan.nextLine();

        if ((kullaniciAdi.equals(userName)&&kullaniciParola.equals(parola))){
            AnaMenu.giris();
        }else{
            System.out.println("Kullanici adi ve  parolaniz yanlis tekrar deneyiniz");
            kullaniciGirisi();
        }
    }
}
