  public int maxProfit(int[] prices) {
        int[][][] dp =new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<dp[i].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return profit(0,1,0,prices,dp,2);
    }
    
    public int profit(int ind,int buy,int profit,int[] prices,int[][][] dp,int count){
        if(count==0)
            return 0;
        if(ind==prices.length)
            return 0;
        if(buy==1){
            if(dp[ind][buy][count]!=-1)
                return dp[ind][buy][count];
            profit=Math.max(-prices[ind]+profit(ind+1,0,profit,prices,dp,count),
                           profit(ind+1,1,profit,prices,dp,count));
        }
        else{
             if(dp[ind][buy][count]!=-1){
                return dp[ind][buy][count];
             }
             profit=Math.max(prices[ind]+profit(ind+1,1,profit,prices,dp,count-1),
                           profit(ind+1,0,profit,prices,dp,count));
        }
        
       dp[ind][buy][count] = profit;
        return profit;
    }