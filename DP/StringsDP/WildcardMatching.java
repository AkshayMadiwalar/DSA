package DP.StringsDP;

import java.util.Arrays;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[p.length()][s.length()];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return match(p,s,p.length()-1,s.length()-1,dp);
    }
    
    public boolean match(String p,String s, int i, int j,int[][] dp){
        
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(i>=0 && j<0){
            for(int k=0;k<=i;k++){
                if(p.charAt(k)!='*')
                    return false;
            }
            return true;
        }
        
        if(dp[i][j]!=-1)
            return dp[i][j]==1?true:false;
        
        if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?'){
            dp[i][j] = match(p,s,i-1,j-1,dp)==true?1:0;
            return dp[i][j]==1?true:false;
        }
        
        if(p.charAt(i)=='*'){
            dp[i][j] = (match(p,s,i-1,j,dp) || match(p,s,i,j-1,dp))==true?1:0;
            return dp[i][j]==1?true:false;
        }
        
        dp[i][j]=0;
        return false;
    }
}
