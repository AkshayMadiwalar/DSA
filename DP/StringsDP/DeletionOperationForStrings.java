package DP.StringsDP;

import java.util.Arrays;

public class DeletionOperationForStrings {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return m+n-2*lcs(word1,word2,m-1,n-1,dp);
    }
    
    public int lcs(String word1,String word2,int i, int j,int[][] dp){
        if(i<0||j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j]=1+lcs(word1,word2,i-1,j-1,dp);
            return dp[i][j];
        }
        dp[i][j]=Math.max(lcs(word1,word2,i-1,j,dp),lcs(word1,word2,i,j-1,dp));
        return dp[i][j];
    }
}
