
import java.util.Scanner;



public class Main {
    static boolean isGiris(int satir, int sutun){
        if(satir < 2 || sutun < 2){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        
        do {            
            System.out.print("Satir boyutu : ");
            int satir = scanner.nextInt();
            System.out.print("Sutun boyutu : ");
            int sutun = scanner.nextInt();
            if(isGiris(satir,sutun)){
                MineSweeper mine = new MineSweeper(satir, sutun);
                mine.run();
                break;
            }else{
                System.out.println("2x2 giris yapmadiniz bir daha deneyiniz!!!");
            }
        } while (true);
        
    }
}
