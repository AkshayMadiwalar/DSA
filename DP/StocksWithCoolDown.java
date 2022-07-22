package DP;

import java.util.Arrays;

public class StocksWithCoolDown {
    public int maxProfit(int[] prices) {
        int[][] dp =new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
            Arrays.fill(dp[i],-1);
        return profit(0,1,0,prices,dp);
        
    }

    // after selling- ind+2---
    
    public int profit(int ind,int buy,int profit,int[] prices,int[][] dp){
        if(ind>=prices.length)
            return 0;
        if(buy==1){
            if(dp[ind][buy]!=-1)
                return dp[ind][buy];
            profit=Math.max(-prices[ind]+profit(ind+1,0,profit,prices,dp),
                           profit(ind+1,1,profit,prices,dp));
        }
        else{
             if(dp[ind][buy]!=-1)
                return dp[ind][buy];
             profit=Math.max(prices[ind]+profit(ind+2,1,profit,prices,dp),
                           profit(ind+1,0,profit,prices,dp));
        }
        dp[ind][buy] = profit;
        return profit;
    }
}
