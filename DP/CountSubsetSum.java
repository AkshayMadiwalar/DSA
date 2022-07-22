package DP;

import java.util.Arrays;

public class CountSubsetSum {
         
    public  int subsum(int ind, int arr[], int sum,int[][] dp){
        
  
        if(ind==0){
            if(sum==0 && arr[0]==0)
                return 2;
            if(sum==0 || arr[0]==sum)
                return 1;
            return 0;
        }
        
        
        if(dp[ind][sum]!=-1){
            return dp[ind][sum];
        }
        //np pick
        int np = subsum(ind-1,arr,sum,dp);
        int p=0;
        if(arr[ind]<=sum)
            p = subsum(ind-1,arr,sum-arr[ind],dp);
        
        dp[ind][sum]=(np+p)%1000000007;
        return dp[ind][sum];
    }

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp=new int[n+1][sum+1];
	    for(int i=0;i<dp.length;i++){
	        Arrays.fill(dp[i],-1);
	    }
	    return subsum(arr.length-1,arr,sum,dp);

	} 
}
