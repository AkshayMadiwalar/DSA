package DP;

public class SubetSumEqualsK {
    public static boolean subsum(int ind, int arr[], int sum, int[][] dp){
        if(sum == 0)
            return true;
        if(ind==0)
            return arr[ind]==sum?true:false;
        
        if(dp[ind][sum]!=0){
            return dp[ind][sum]==1?true:false;
        }
        //no pick
        boolean nopick = subsum(ind-1,arr,sum,dp);
        // pick
        boolean pick = false;
        
        if(arr[ind]<=sum)
            pick = subsum(ind-1,arr,sum-arr[ind],dp);
        
        boolean val = nopick || pick;
        
        if(val==true)
            dp[ind][sum]=1;
        else
            dp[ind][sum]=2;
        
        return nopick || pick;
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][]  dp = new int[101][(int)Math.pow(10,5)];
        return subsum(N-1,arr,sum,dp);
    }
}
