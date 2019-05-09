package Exam.Huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Huawei3 {
    static int total = 0;
    static int k;
    static ArrayList<String> output = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        int[] kids = new int[k];
        pattern(kids,0, n);
        System.out.println(total);
        for (String s:
             output) {
            System.out.println(s);
        }
    }

    public static void pattern(int[] kids, int I, int left){
        if(left==0){
            printArray(kids, k);
            return ;
        }
        for (int i = I; i < k; i++) {
            kids[i]++;
            pattern(kids,i,left-1);
            kids[i]--;
        }
    }

    public static void printArray(int[] kids, int n){
        total++;
        String ele = "";
        for (int i = 0; i < kids.length; i++) {
            for (int j = 0; j < kids[i]; j++) {
                ele+="*";
            }
            if(i != kids.length-1){
                ele+="|";
            }
        }
        output.add(ele);
    }
}
