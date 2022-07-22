package DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
  
        return lis(0,-1,nums,dp);
    }
    
    public int lis(int ind,int prev,int[] nums,int[][] dp){
        
        if(ind==nums.length)
            return 0;
        
        if(dp[ind][prev+1]!=-1)
            return dp[ind][prev+1];
        
        int nt = lis(ind+1,prev,nums,dp);
        int t=0;
        if(prev==-1 || nums[ind]>nums[prev]){
            t=1+lis(ind+1,ind,nums,dp);
        }
        
        dp[ind][prev+1]=Math.max(t,nt);
        return Math.max(t,nt);
    }
}
