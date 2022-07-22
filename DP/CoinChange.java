package DP;

public class CoinChange {
    
    //------------Minimum number of coins to select------------------
       
    //---Recursion-----
    public int coin(int ind,int[] coins,int amount,int[][] dp){    
        if(ind==0){
            if(amount % coins[ind] == 0)
                return amount / coins[ind];
            return (int)Math.pow(10,9);
        }
        int np = coin(ind-1,coins,amount,dp);
        int p = (int)Math.pow(10,9);
        if(coins[ind]<=amount){
            p=1+coin(ind,coins,amount-coins[ind],dp);
        }
        return Math.min(p,np);
    }

public int coinChange(int[] coins, int amount) {
    int[][] dp = new int[coins.length+1][amount+1];
    
    for(int i=0;i<=coins.length;i++)
        for(int j=0;j<=amount;j++)
            dp[i][j]=0;
    

     //---Tabulation--code       
    for(int a=0;a<=amount;a++){
        if(a%coins[0]==0)
            dp[0][a]=a/coins[0];
        else
            dp[0][a]=(int)Math.pow(10,9);
    }
    
    for(int ind=1;ind<coins.length;ind++){
        for(int a=0;a<=amount;a++){
            
            int np = dp[ind-1][a];
            int p = (int)Math.pow(10,9);
            if(coins[ind]<=a){
                 p=1+dp[ind][a-coins[ind]];
            }
           
            dp[ind][a]=Math.min(np,p);
        }
    }
    
    return dp[coins.length-1][amount]==(int)Math.pow(10,9)?-1:dp[coins.length-1][amount];
    // int min =  coin(coins.length-1,coins,amount,dp);
    // return min==(int)Math.pow(10,9)?-1:min;
}
}
