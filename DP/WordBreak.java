package DP;

import java.util.*;

public class WordBreak {
    public boolean func(String s, int ind, List<String> dict){
        
        if(ind==s.length())
            return true;
        
        for(int  i=ind;i<s.length();i++){
            if(dict.contains(s.substring(ind,i+1)))
                if(func(s,i+1,dict))
                    return true;
        }
        return false;
    }
    
    public boolean funcMemo(String s, int ind, List<String> dict, int[] dp){
        
        if(ind==s.length())
            return true;
        
        if(dp[ind]!=-1)
            return dp[ind]==1?true:false;
        
        for(int  i=ind;i<s.length();i++){
            if(dict.contains(s.substring(ind,i+1)))
    
                    if(funcMemo(s,i+1,dict,dp)) {
                        if(i<s.length()-1)dp[i+1]=1;
                        return true;
                    }           
                    else {
                        if(i<s.length()-1)
                        dp[i+1]=0;
                    }         
        }
        return false;
    }
    
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];  
        Arrays.fill(dp,-1);
        return funcMemo(s,0,wordDict,dp);
    }
}
