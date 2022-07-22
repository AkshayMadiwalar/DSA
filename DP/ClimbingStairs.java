package DP;

import java.util.HashMap;

public class ClimbingStairs {

    HashMap<Integer,Integer> map = new HashMap<>();
    


    //----Memoization-----  Time O(n) Space O(n)+O(n)  (stack space + hashmap)
    public int climbStairs(int n) {
        
        if(n==0 || n==1)    return 1;
        if(n<0) return 0;
        
        int prev = -1;
        int prev2 = -1;
        if(!map.containsKey(n-1)){
            prev = climbStairs(n-1);
            map.put(n-1,prev);
        }
        
        if(!map.containsKey(n-2)){
            prev2 = climbStairs(n-2);
            map.put(n-2,prev2);
        }
        
        return map.get(n-1)+map.get(n-2);
    }


    //---- Tabulation----- Time O(n) Space O(n) dp array
    public int climbStairsTabulation(int n){
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }


    // ----- Space Optimized------ Time  O(n) Space O(1)
    public int clinStairs3(int n){
        int prev=1;
        int prev2=1;
        int cur=prev+prev2;
        if(n==1)    return prev;
        for(int i=2;i<=n;i++){
            cur=prev+prev2;
            prev2=prev;
            prev=cur;
        }
        return cur;
    }
}
