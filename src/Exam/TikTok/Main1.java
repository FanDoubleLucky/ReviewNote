package Exam.TikTok;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static boolean[] traveled;
    static int[][] cost;
    static int[][] dp;
    static int n;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = in.nextInt();
            }
        }
        in.close();
        traveled = new boolean[n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        Arrays.fill(traveled, false);
        System.out.println(dfs(n, 0));

    }
    static int dfs(int count, int station){

        if(count<=0){
            return cost[station][0];
        }
        if(dp[station][count-1]>=0){
            return dp[station][count-1];
        }
        dp[station][count-1] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(traveled[i]||i==station){continue;}

            traveled[i] = true;
            dp[station][count-1] = Math.min(cost[station][i]+dfs(count-1, i), dp[station][count-1]);
            traveled[i] = false;

        }
//        dp[station][count] = res;
        return dp[station][count-1];
    }
}
