package DP;

public class HouseRobberI {
    
    //Recursion
    public int sumRecursive(int ind,int[] nums){
        if(ind==0)  return nums[ind];
        if(ind<0)   return 0;
        int pick = nums[ind]+sumRecursive(ind-2,nums);
        int notpick = sumRecursive(ind-1,nums);
        return Math.max(pick,notpick);    
    }
    
    //Tabulation
    public int sumTb(int[] nums){
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int pick = nums[i];
            if(i>1) pick+=dp[i-2];
            int npick =  dp[i-1];
            dp[i]=Math.max(pick,npick);
        }
        return dp[nums.length-1];
    }
    
    //tabulation with space Optimization ---- O(N) T, O(1) Space    
    public int sumSO(int[] nums){
        int prev2=0;
        int prev=nums[0];
        
        for(int i=1;i<nums.length;i++){
            int pick = nums[i]+prev2;
            int npick = prev;
            int cur =Math.max(pick,npick);
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
    
    
    public int rob(int[] nums) {
        //return sum(nums.length-1,nums);
        return sumSO(nums);
    }
}
