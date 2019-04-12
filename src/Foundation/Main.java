package Foundation;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    private static int[] input = new int[100000];
    private static int[] count = new int[200000];
    private static int[] trav = new int[200000];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; ++ i)
        {
            input[i] = sc.nextInt();
        }
        for (int i = 0; i < n; ++ i)
        {
            func(input[i]);
        }
        int result = 10000000;
        for (int i = 0; i < 200000; ++ i)
        {
            if (trav[i] == n)
            {
                result = result >= count[i] ? count[i]:result;
            }
        }
        System.out.println(result);
    }

    public static void func(int t) {
        int step = 0;
        int temp = t;
        while(temp <= 100000) {
            trav[temp]++;
            count[temp] +=step ++;
            temp = temp << 1;
        }
        step = 0;
        while(t != 0) {
            if (((t&1) != 0) && (t!=1))
            {
                t = t >> 1;
                step++;
                count[t] += step;
                trav[t]++;

                int tt = t;
                int ele = step;
                while(tt <= 100000)
                {
                    tt <<= 1;
                    ele++;
                    trav[tt] ++;
                    count[tt] += ele;
                }
            }
            else
            {
                t = t >> 1;
                step++;
                count[t] += step;
                trav[t]++;
            }
        }
    }
}


class Main1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < 2*n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        double min = 0;
        if(a[n]/2.0 > a[0]){
            min = a[n];
            System.out.println(Math.min(n*3*min, w));
        }
        else{
            min = a[0];
            System.out.println(Math.min(n*3*min/2.0, w));
        }
    }
}

//public class Main {
//    static int N;
//    static int[] d;
//    static int[] p;
//
//
//    public static void main(String[] args) {
//        ArrayList<Integer> output=new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        if (N == 0) {
//            System.out.println(0);
//            return;
//        }
//        d = new int[N];
//        for (int i = 0; i < N; i++) {
//            d[i] = sc.nextInt();
//        }
//        p = new int[N];
//        for (int i = 0; i < N; i++) {
//            p[i] = sc.nextInt();
//        }
//        dfsChoice(0,true,0,0,output);
//        Collections.sort(output);
//        System.out.println(output.get(0));
//    }
//
//    private static void dfsChoice(int index, boolean YN, int price, int power, ArrayList<Integer> output) {
//        if (index==N){
//            output.add(price);
//            return;
//        }
//        if (YN){
//            price+=p[index];
//            power+=d[index];
//        }
//        if (power<d[index]){
//            return;
//        }
//        dfsChoice(index+1,true, price, power, output);
//        dfsChoice(index+1,false, price, power, output);
//    }
//}