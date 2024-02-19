
import java.util.Scanner;





public class MineSweeper {
    int row;
    int column;

    MineSweeper(int row, int column) {
        this.column = column;
        this.row = row;
    }
    
    
    
    String[][] kopyaDizi(String[][] arr, int mayinSayisi){
        int sayi = 0;
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.column; j++){
                if(sayi < mayinSayisi && Math.random()*100 < 25){
                    if(arr[i][j] == null || arr[i][j].equals("- ")){
                        sayi++;
                        arr[i][j] = "* ";
                    }
                }else{
                    if(arr[i][j] == null || arr[i][j].equals("- ")){
                        arr[i][j] = "- ";
                    }
                }
            }
            if(i == this.row-1 && sayi < mayinSayisi){
                i = -1;
            }
        }
        return arr;
    }
    
    String[][] esasDizi(String[][] esasDizi){
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.column; j++){
                esasDizi[i][j] = "- ";
            }
        }
        return esasDizi;
    }
    
    boolean isDahaOnce(int satir, int sutun){
        String[][] dahaOnce = new String[this.row][this.column];
        if(dahaOnce[satir][sutun] == null){
            dahaOnce[satir][sutun] = "*";
            return true;
        }else{
            return false;
        }
    }
    
    void print(String[][] arr){
        for(String[] i : arr){
            for(String j : i){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    void run(){
        
        int mayinSayisi = this.column*this.row / 4;
        
        String[][] esasDizi = new String[this.row][this.column];
        String[][] kopyaDizi = new String[this.row][this.column];
        
        kopyaDizi = kopyaDizi(kopyaDizi, mayinSayisi);
        esasDizi = esasDizi(esasDizi);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mayinlarin Konumu");
        
        System.out.println("==========================");
        System.out.println("Mayin Tarlasi Oyununa Hosgeldiniz !");
        print(esasDizi);
        do {
            System.out.print("Satir giriniz : ");
            int satir = scanner.nextInt();
            System.out.print("Sutun giriniz : ");
            int sutun = scanner.nextInt();
            System.out.println("==============================");
            if(isDahaOnce(satir, sutun)){
                if(kopyaDizi[satir][sutun].equals("* ")){
                    System.out.println("Game Over!");
                    print(kopyaDizi);
                    System.out.println("================================");
                    break;
                }else{
                    int giris = 0;
                    for(int i = 0; i < this.row; i++){
                        for(int j = 0; j < this.column; j++){
                            if(kopyaDizi[i][j].equals("* ") && ((i == satir && Math.abs(j - sutun) == 1) || (Math.abs(i - satir) == 1 && j == sutun) || (Math.abs(i - satir) == 1 && Math.abs(j - sutun) == 1))){
                                giris++;
                                esasDizi[satir][sutun] = (giris) + " ";
                            }
                            else if(Math.abs(i - satir) == 1 || Math.abs(j-sutun) == 1){
                                esasDizi[satir][sutun] = giris + " ";
                            }
                        }
                    }
                        
                    int sayi = 0;
                    for(int i = 0; i < this.row; i++){
                        for(int j = 0; j < this.column; j++){
                            if(kopyaDizi[i][j].equals(esasDizi[i][j])){
                                sayi++;
                            }
                        }
                    }
                    if(0 == sayi){
                        System.out.println("Oyunu kazandiniz !");
                        break;
                    }
                    print(esasDizi);
                }
            }else{
                System.out.println("bu koordinat daha once secildi, baska bir koordinat girin");
            }
        } while (true);
    }
}
