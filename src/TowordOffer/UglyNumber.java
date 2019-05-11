package TowordOffer;

import java.util.LinkedList;
import java.util.Queue;

public class UglyNumber {

    public static int GetUglyNumber_Solution(int index) {
        if(index<7){
            return index;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int p2=0, p3=0, p5=0;
        for(int i=1;i<index;i++){
            arr[i] = Math.min(arr[p2]*2, Math.min(arr[p3]*3, arr[p5]*5));
            if(arr[i]==arr[i]*2){p2++;}
            if(arr[i]==arr[i]*3){p3++;}
            if(arr[i]==arr[p5]*5){p5++;}
        }
        return arr[index-1];
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution(7);
    }
}

