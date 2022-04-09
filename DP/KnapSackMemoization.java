package DP;

public class KnapSackMemoization {
  

    //Memoization, dp table, still uses recursion, but no of recurxive calls are decreased

    public static int knapSack(int W, int[] wt, int[] val, int n, int[][] dp){
        if(n==0 || W==0){
            return 0;
        }

        if(dp[n][W]!=-1){
            return dp[n][W];
        }

        if(wt[n-1]<=W){
            return dp[n][W] = Math.max(val[n-1]+knapSack(W-wt[n-1], wt, val, n-1,dp),knapSack(W, wt, val, n-1,dp));
        }else{
            return dp[n][W] = knapSack(W, wt, val, n-1,dp);
        }
        


    }

    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;

        int[][] dp = new int[n+1][W+1];
        // Loop to initially filled the 
        // table with -1 
        for(int i = 0; i < n + 1; i++)   
            for(int j = 0; j < W + 1; j++)   
                dp[i][j] = -1; 

        System.out.println(knapSack(W, wt, val, n,dp));
    }
}
