package DP;

import java.util.Arrays;

public class StocksWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return maxProf(0,prices,1,0,fee,dp);
    }

    //----subtract transaction fee after every sell---------
    
    public int maxProf(int ind,int[] prices,int buy,int profit,int fee,int[][] dp){
        
        if(ind==prices.length)
            return 0;
        
        if(dp[ind][buy]!=-1)
            return dp[ind][buy];
        
        if(buy==1){
            int b = -prices[ind]+maxProf(ind+1,prices,0,profit,fee,dp);
            int nb = maxProf(ind+1,prices,1,profit,fee,dp);
            profit=Math.max(b,nb);
        }
        else{
            int s = prices[ind]-fee+maxProf(ind+1,prices,1,profit,fee,dp);
            int ns = maxProf(ind+1,prices,0,profit,fee,dp);
            profit=Math.max(s,ns);
        }
        
        return dp[ind][buy]=profit;
    }
}
