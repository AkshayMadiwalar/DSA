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



