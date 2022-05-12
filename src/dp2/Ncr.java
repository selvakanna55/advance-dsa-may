package dp2;

public class Ncr {
    public static void main(String[] args) {
        int n = 5;
        int r = 3;
        int dp[] = new int[n+1];
//        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            //nc0 ->1
//            dp[i][0] = 1;
//            dp[i][i] = 1;
            dp[i] = 1;
        }
        for(int i=2;i<=n;i++){
            for(int j=i-1;j>=1;j--){
                dp[i] = dp[i]+dp[i-1];
            }
        }
        //nc2
        //5c3
        System.out.println(dp[3]);
        System.out.println(dp[2]);

    }
}
