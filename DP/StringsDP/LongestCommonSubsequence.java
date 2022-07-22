package DP.StringsDP;

import java.util.Arrays;

public class LongestCommonSubsequence {

    //Recursion------
    public int func(String text1, int i, String text2, int j){
        if(i<0 || j<0)
            return 0;
        if(text1.charAt(i)==text2.charAt(j))
            return 1+func(text1,i-1,text2,j-1);
        return Math.max(func(text1,i,text2,j-1),func(text1,i-1,text2,j));
    }

    //Memoization-----------------
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
    

    //Tabulation------
    public int funcTab(String text1, String text2, int[][] dp){
        //shifting index
        for(int i=0;i<dp.length;i++)
            dp[i][0]=0;
        for(int j=0;j<dp[0].length;j++)
            dp[0][j]=0;
        
        for(int i=1;i<dp.length;i++)
            for(int j=1;j<dp[i].length;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        
        return dp[dp.length-1][dp[0].length-1];
    }
    
    
    
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return funcMemo(text1,text1.length()-1,text2,text2.length()-1,dp);
    }
}
