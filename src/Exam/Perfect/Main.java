package Exam.Perfect;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] dp;
    static int[][] cost;
    static boolean[][] used;
    static int n, m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cost[i][j] = -1*in.nextInt();
            }
        }
        dp = new int[n+1][m+1];
        used = new boolean[n+1][m+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(used[i],false);
        }
        System.out.println(dfs(1, 1));

    }

    static int dfs(int row, int col){
        if(used[row][col]){
            return dp[row][col];
        }
        else{
            int price = Integer.MAX_VALUE;
            if(row+1<=n){
                price = Math.min(dfs(row+1, col), price);
            }
            if(col+1<=m){
                price = Math.min(dfs(row, col+1), price);
            }
            dp[row][col] = cost[row-1][col-1]+price;
            used[row][col] = true;
        }
        return dp[row][col];
    }
}
