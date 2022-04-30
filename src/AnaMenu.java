import java.util.Scanner;

public class AnaMenu implements AnaMenuInterface {

    static Scanner scan = new Scanner(System.in);
    static int secim = 0;

    public static void giris() {
        Islemler obj1= new Islemler();
        AnaMenu obj = new AnaMenu();
        System.out.println("====================================\n" +
                "\t ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ\n" +
                "\t====================================\n" +
                "\t 1- ÖĞRENCİ İŞLEMLERİ\n" +
                "\t 2- ÖĞRETMEN İŞLEMLERİ\n" +
                "\t 3- ŞİFRE DEĞİŞİKLİĞİ\n" +
                "\t 4- ÇIKIŞ");


        System.out.print("Lutfen seciminizi yapiniz:");


        try {
            secim = scan.nextInt();
            switch (secim) {
                case 1:
                    obj.ogrenciIslemleri();
                    break;
                case 2:
                    obj.ogretmenIslemleri();
                    break;
                case 3:
                    obj1.sifreDegistir();
                    break;
                case 4:
                    obj.cikis();
                    break;
                default:
                    System.out.println("Lutfen gecerli secim yapiniz");

            }
        } catch (Exception e) {
            System.out.println("lutfen sayi giriniz");
            scan.nextLine();
            giris();
        }


    }

    @Override
    public void ogrenciIslemleri() {
        Islemler.IslemlerMenu(1);

    }

    @Override
    public void ogretmenIslemleri() {
        Islemler.IslemlerMenu(2);
    }

    @Override
    public void cikis() {
        System.out.println("gule gule");

    }
}
