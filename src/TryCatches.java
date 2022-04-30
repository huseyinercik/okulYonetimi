import java.util.Scanner;

public class TryCatches {
    public static int intGiris() {
        Scanner scan = new Scanner(System.in);
        int giris = 0;
        boolean flag=false;
        do {

            if (flag==true){
                scan.nextLine();
                flag=false;
            }
            try {
                giris=scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Hatali giris yaptiniz");
                flag=true;
                intGiris();
            }


        }while (flag);
     return giris;
    }
}
