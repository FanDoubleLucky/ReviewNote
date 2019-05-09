package Exam.Huawei;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] or = new String[N];
        String[] right = new String[N];
        for(int i = 0; i < N; i++){
            or[i] = sc.nextLine();
        }

        for(int i = 0; i < N; i++){
            right[i] = sc.nextLine();
        }

        int total = 0;
        for (int i = 0; i < N; i++) {
            total+=check(or[i], right[i]);
        }
        System.out.println(total);
    }


    public static int check(String A, String B){
        int l1 = A.length();
        int l2 = B.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if(i==0){
                    dp[i][j] = j;
                }else if (j==0){
                    dp[i][j] = i;
                }else if (A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        return dp[l1][l2];
    }
}
