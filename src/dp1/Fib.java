package dp1;

import java.util.ArrayList;

public class Fib {
    static int fib(int n, int dp[]){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        System.out.println(n);
        int res = fib(n-1, dp)+fib(n-2, dp);
        dp[n] = res;
        return res;
    }
    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n+1];
//        for(int i=0;i<=n;i++)
//            dp[i] = -1;
//        System.out.println(fib(n, dp));
//        dp[0] = 0;
//        dp[1] = 1;
//        for(int i=2;i<=n;i++){
//            dp[i] = dp[i-1]+dp[i-2];
//        }
//        System.out.println(dp[n]);
//
        int prev2 = 0;
        int prev1 = 1;
        for(int i=2;i<=n;i++){
            int curri = prev1+prev2;
            prev2 = prev1;
            prev1= curri;
        }
        System.out.println(prev1);

    }
}
