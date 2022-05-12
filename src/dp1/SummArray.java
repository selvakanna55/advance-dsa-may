package dp1;

public class SummArray {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5};
        for(int i=1;i<arr.length;i++){ // O(n)
            arr[i] = arr[i]+arr[i-1];
        }

        //sum from l to r
        int l  = 2, r = 5; // q*n
//        int currSum = 0;
//        for(int i=l;i<=r;i++){
//            currSum+=arr[i];
//        }
        System.out.println(arr[r]-arr[l-1]);
    }
}
