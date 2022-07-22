package DP;

import java.util.Arrays;

public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
         return decode(0,s,dp);
    }
    
    public int decode(int ind,String s,int[] dp){
        
        if(ind>=s.length()){
            return 1;
        }
        if(ind==s.length()-1){
            if(s.charAt(ind) >='1' && s.charAt(ind) <= '9'){
                return 1; 
            }
            return 0; 
        }
        if(dp[ind]!=-1)
            return dp[ind];
        int single = 0;
        int doub = 0;
        if(s.charAt(ind) >='1' && s.charAt(ind) <= '9')
            single = decode(ind+1,s,dp);
        
        
        if(ind+1<s.length() && s.charAt(ind)!='0'){
            int val = (s.charAt(ind)-'0')*10 + s.charAt(ind+1)-'0';
            if(val>=1 && val<=26){
                doub = decode(ind+2,s,dp);
            }      
        }
        
        dp[ind]=single+doub;
        return single+doub;
    }
}
