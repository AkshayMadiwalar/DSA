package DP.StringsDP;

import java.util.Arrays;

public class StringInterleavving {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()>s3.length())
            return false;
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i=0;i<s1.length();i++)
            Arrays.fill(dp[i],-1);
        return interleave(s1,s2,0,0,0,s3,dp);
    }
    
    public boolean interleave(String s1,String s2,int i, int j,int k, String s3,int[][] dp){
        if(i==s1.length())
            return s2.substring(j).equals(s3.substring(k));
        
        
        if(j==s2.length())
            return s1.substring(i).equals(s3.substring(k));
      
        
        boolean ans = false;
       
 
        if(dp[i][j]!=-1)
                return dp[i][j]==1?true:false;
        

        if(s3.charAt(k)==s1.charAt(i) && interleave(s1,s2,i+1,j,k+1,s3,dp)
            ||
            s3.charAt(k)==s2.charAt(j) && interleave(s1,s2,i,j+1,k+1,s3,dp))
    
            ans = true;
        
        dp[i][j]=ans?1:0;
        
        return ans;
    }
}
