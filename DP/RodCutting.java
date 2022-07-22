package DP;

import java.util.Arrays;

public class RodCutting {
    public int rod(int ind,int N, int price[], int[][] dp){
        if(ind==0)
            return price[0]*N;
            
        if(dp[ind][N]!=-1)
            return dp[ind][N];
            
        int nt=rod(ind-1,N,price,dp);
        int t=(int)Math.pow(10,9)*-1;
        int rodlen=ind+1;
        if(ind+1<=N){
            t=price[ind]+rod(ind,N-rodlen,price,dp);
        }
        dp[ind][N]=Math.max(nt,t);
        return Math.max(nt,t);
    }
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp = new int[price.length][n+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return rod(price.length-1,n,price,dp);
    }
}
