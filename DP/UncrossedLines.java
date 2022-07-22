package DP;

import java.util.Arrays;

public class UncrossedLines {
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return lcs(nums1,nums2,0,0,dp);
    }
    
    //---Longest Common Subsequence----
    public int lcs(int[] nums1,int[] nums2,int i,int j,int[][] dp){
        if(i>=nums1.length)
            return 0;
        if(j>=nums2.length)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(nums1[i]==nums2[j])
            return 1+lcs(nums1,nums2,i+1,j+1,dp);
        dp[i][j]=Math.max(lcs(nums1,nums2,i,j+1,dp),lcs(nums1,nums2,i+1,j,dp));
        return dp[i][j];
    }
}
