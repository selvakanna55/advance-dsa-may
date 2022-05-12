package dp1;

public class SubsNoAdj {
    static  int f(int n, int arr[], int dp[]) {
        if(n==0) return  arr[0];
        if(n<0) return  0;
        if(dp[n]!=-1) return dp[n];
        int pick = arr[n] + f(n-2, arr, dp);
        int notPick = 0+f(n-1, arr, dp);
        return dp[n]=Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};
        int n = arr.length;
        int dp[] = new  int[n+1];
//        for(int i=0;i<=n;i++) dp[i] = -1;
//        dp[0] = arr[0];
//        dp[1] = Math.max(arr[0],arr[1]);
//        for(int i=2;i<n;i++){
//            int pick = arr[i]+dp[i-2];
//            int  notPick =dp[i-1];
//            dp[i] = Math.max(pick, notPick);
//        }
//        System.out.println(dp[n-1]);

        int prev2 = arr[0];
        int prev1 = Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            int pick = arr[i]+prev2;
            int  notPick =prev1;
            int ans = Math.max(pick, notPick);
            prev2 = prev1;
            prev1  = ans;
        }
        System.out.println(prev1);

//        System.out.println(f(n - 1, arr, dp));

    }
}
