package DP.StringsDP;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        //return func(s,t,s.length()-1,t.length()-1);
        return funcTab(s,t,dp);
    }
    
    public int funcTab(String s,String t,int[][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[s.length()][t.length()];
    }
    
    public int func(String s, String t, int i, int j){
        if(j<0)
            return 1;
        if(i<0)
            return 0;
        if(s.charAt(i)==t.charAt(j))
            return func(s,t,i-1,j-1)+func(s,t,i-1,j);
        return func(s,t,i-1,j);
    }
}
