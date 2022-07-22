package DP.StringsDP;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
      
        String text1=s;
        String text2="";
        for(int i=s.length()-1;i>=0;i--){
            text2+=s.charAt(i);
        }
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return funcMemo(text1,text1.length()-1,text2,text2.length()-1,dp);
    }
    public int funcMemo(String text1, int i, String text2, int j,int[][] dp){
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j] = 1+funcMemo(text1,i-1,text2,j-1,dp);
            return dp[i][j];
        }
        dp[i][j] = Math.max(funcMemo(text1,i,text2,j-1,dp),funcMemo(text1,i-1,text2,j,dp));
        return dp[i][j];
    }
}
