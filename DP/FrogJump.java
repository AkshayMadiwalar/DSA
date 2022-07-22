package DP;

import java.util.HashMap;

public class FrogJump {
    public boolean jump(int[] stones, int ind,int steps, HashMap<Integer,Integer> map,int[][] dp){
        
        boolean ans =   false;
        
        if(ind>=stones.length)
            return false;
        
        if(stones[ind]==stones[stones.length-1]){
            return true;
        }
    
        
        if(dp[ind][steps]!=0)
            return dp[ind][steps]==1?true:false;
        
        for(int i=steps-1;i<=steps+1;i++){
            if(i>0)
                if(map.containsKey(stones[ind]+i))
                    ans = ans || jump(stones,map.get(stones[ind]+i),i,map,dp);
        }
        
        dp[ind][steps]=ans==true?1:2;
        return ans;
    }
    
    public boolean canCross(int[] stones) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<stones.length;i++){
                map.put(stones[i],i);
        }
        int[][] dp = new int[stones.length+1][stones.length+1];
        return jump(stones,0,0,map,dp);
    }
}
