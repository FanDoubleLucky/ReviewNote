package TowordOffer;

public class ReverseTouple {
    static int swapTime = 0;
    static int[] aux;
    public static int InversePairs(int [] array) {
        int n = array.length;
        MSort(array, 0, n-1);
        return swapTime;
    }

    public static void MSort(int[] array, int lo, int hi){
        if(lo>=hi){
            return;
        }
        int mid = lo+(hi-lo)/2;
        MSort(array, lo, mid);
        MSort(array, mid+1, hi);
        merge(array, lo, mid, hi);
    }

    public static void merge(int[] array, int lo, int mid, int hi){

        for(int i=lo;i<=hi;i++){
            aux[i] = array[i];
        }
        int left = lo, right = mid+1;
        for(int i=lo;i<=hi;i++){
            if(left>mid){array[i]=aux[right++];swapTime+=(mid-left+1);}
            else if(right>hi){array[i]=aux[left++];}
            else if(aux[left]>aux[right]){array[i]=aux[right++];swapTime+=(mid-left+1);}
            else{array[i]=aux[left++];}
        }
    }

    public static void main(String[] args) {
        int[] arr ={364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        aux = new int[arr.length];
        InversePairs(arr);
        System.out.println(swapTime);
        for (int ele :
                arr) {
            System.out.println(ele);
        }
    }
}
