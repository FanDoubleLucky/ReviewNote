package TowordOffer;

public class GetNumberOfK {
    public static int GetNumberOfK(int [] array , int k) {
        int n = array.length;
        if(n==0){return 0;}
        int lo = 0, hi = n-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(array[mid] >= k){
                hi = mid-1;
            }else if(array[mid]<k){
                lo = mid+1;
            }
        }
        int start = lo;
        lo = 0;
        hi = n-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(array[mid] > k){
                hi = mid-1;
            }else if(array[mid]<=k){
                lo = mid+1;
            }
        }
        int end = hi;
        return end-start+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(arr, 3));
    }

}
