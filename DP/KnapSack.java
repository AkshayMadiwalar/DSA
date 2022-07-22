package DP;

import java.util.Arrays;

public class KnapSack {
    class Solution 
    { 
        //Function to return max value that can be put in knapsack of capacity W.
         int knapSack(int W, int wt[], int val[], int n) 
        { 
             // your code here
             int[][] dp = new int[n][W+1];
             for(int i=0;i<n;i++){
                 Arrays.fill(dp[i],-1);
             }
             return kp(val.length-1,W,wt,val,dp);
        } 
        
         int kp(int ind,int W,int wt[], int val[], int[][] dp){
            if(ind==0){
                if(wt[ind]<=W)
                    return val[ind];
                else
                    return 0;
            }
            
            if(dp[ind][W]!=-1)
                return dp[ind][W];
            
            int nt = 0+kp(ind-1,W,wt,val,dp);
            int t=Integer.MIN_VALUE;
            if(wt[ind]<=W){
                t=val[ind]+kp(ind-1,W-wt[ind],wt,val,dp);
            }
            dp[ind][W] = Math.max(nt,t);
            return dp[ind][W];
        }
        
     
    }
    
    
     
}
