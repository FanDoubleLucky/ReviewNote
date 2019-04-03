package Foundation;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleIn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = new String[5];
        int[] a = new int[10];
        int i = 10;

        while(in.hasNextInt()&&i>0){
            a[--i] = in.nextInt();
        }
        for (int input :
                a) {
            System.out.println(input);
        }
    }
}
