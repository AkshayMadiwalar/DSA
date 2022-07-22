package DP.StringsDP;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return edit(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
    
    public int edit(String word1,String word2,int i, int j,int[][] dp){
        if(i<0)return j+1;
        if(j<0)return i+1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return edit(word1,word2,i-1,j-1,dp);
        }
        int insert=1+edit(word1,word2,i,j-1,dp);
        int delete=1+edit(word1,word2,i-1,j,dp);
        int replace=1+edit(word1,word2,i-1,j-1,dp);
        dp[i][j]=Math.min(Math.min(insert,delete),replace);
        return dp[i][j];
    }
}
