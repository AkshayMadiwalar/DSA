package DP;

import java.util.HashSet;

public class MinCostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        
        int lastDay = days[days.length-1];
        
        HashSet<Integer> daysSet = new HashSet<>();
        
        for(int i=0;i<days.length;i++){
            daysSet.add(days[i]);
        }
        
        int[] dp = new int[lastDay+1];
        
        for(int i=1;i<=lastDay;i++){
            if(!daysSet.contains(i)){
                dp[i]=dp[i-1];
                continue;
            }
            
            int firstDay = costs[0]+dp[i-1];
            int seventh = costs[1]+dp[Math.max(i-7,0)];
            int thirthy = costs[2]+dp[Math.max(i-30,0)];
            
            dp[i] = Math.min(Math.min(firstDay,seventh),thirthy);
        }
        
        return dp[lastDay];
    }
}



// Alternate solution 

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] isPresent = new boolean[days[days.length-1]+1];
        for(int x:days){
            isPresent[x]=true;
        }
        Integer[] dp = new Integer[isPresent.length];
        return solve(isPresent,days[0],costs,dp);
    }

    private int solve(boolean[] isPresent,int day,int[] costs,Integer[] dp){
        if(day>=isPresent.length){
            return 0;
        }
        if(dp[day]!=null){
            return dp[day];
        }
        if(isPresent[day]){
           int a = costs[0] + solve(isPresent,day+1,costs,dp);
           int b = costs[1] + solve(isPresent,day+7,costs,dp);
           int c = costs[2] + solve(isPresent,day+30,costs,dp);
           return dp[day] = Math.min(a,Math.min(b,c));
        }
        else{
            return dp[day] = solve(isPresent,day+1,costs,dp);
        }
    }
}