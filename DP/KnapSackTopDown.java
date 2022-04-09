package DP;

public class KnapSackTopDown {

    public static int knapSack(int W,int[]wt, int[] val, int n){
        int[][] dp = new int[n+1][W+1];

        //base condtion
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){

                //base condition, first row and column initilation
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }

                //convert brute force code to dp tabe code 
                else if(wt[i-1] <= W){
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][W-j],dp[i-1][j]);
                }

                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[n+1][W+1];
    }
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
