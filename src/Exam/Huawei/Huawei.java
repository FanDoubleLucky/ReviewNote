package Exam.Huawei;

import java.util.Scanner;

public class Huawei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                matrix[i][j] = sc.nextInt();
//                System.out.println(matrix[i][j]);
            }
        }
        int M = sc.nextInt();

        M = M%4;
        while (M>0){
            M--;
            rotate(matrix);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void rotate(int[][] matrix){
        int n = matrix.length;
        int mid = (n-1)/2;
        for (int i = 0; i <= mid; i++) {
            for (int j = 0; j < n-mid-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
