package DP;

import java.util.Arrays;

public class CoinChangeII {

    //Total number of ways to select coins-----
    
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return count(coins.length-1,amount,coins,dp);
    }
    
    public int count(int ind, int amount, int[] coins,int[][] dp){
        if(ind==0){
            if(amount%coins[ind]==0) return 1;
            return 0;
        }
        if(dp[ind][amount]!=-1)
            return dp[ind][amount];
        
        int nt=count(ind-1,amount,coins,dp);
        int t=0;
        if(coins[ind]<=amount){
            t=count(ind,amount-coins[ind],coins,dp);
        }
        dp[ind][amount]=t+nt;
        return t+nt;
    }
}
