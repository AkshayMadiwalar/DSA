package DP.StringsDP;

import java.util.Arrays;

public class MinimumInsertionsToMakePalindrome {
    public int minInsertions(String s) {
        
        String s1=s;
        String s2="";
        for(int i=s.length()-1;i>=0;i--){
            s2+=s1.charAt(i);
        }
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return s.length()-lcs(s1,s2,s.length()-1,s.length()-1,dp);
    }
    
    public int lcs(String s1,String s2,int i, int j,int[][] dp){
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = 1+lcs(s1,s2,i-1,j-1,dp);
            return dp[i][j];
        }
        dp[i][j] = Math.max(lcs(s1,s2,i,j-1,dp),lcs(s1,s2,i-1,j,dp));
        return dp[i][j];
    }
}
