package Lz78;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        int choice = 1;
       while ((choice == 1) || (choice == 2)) {
           System.out.println("PLease Select a mode 1-encode,2-decode ... anything else will exit");
           Scanner sc = new Scanner(System.in);
           choice = Integer.parseInt(sc.nextLine());
           if (choice == 1) {
               encoder.main(args);
           } else if (choice == 2) {
               decoder.main(args);
           }
       }
    }
}

