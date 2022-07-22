package DP.JumpGame;

public class JumpGameII {
    public int jump(int[] nums) {
        int[] dp =new int[nums.length];
        return jump(0,nums,dp,(int)Math.pow(10,9));
    }
    public int jump(int ind,int[] nums,int[] dp,int min){
        
        if(ind==nums.length-1)
            return 0;
        
        if(dp[ind]!=0)
            return dp[ind];
        
        for(int i=1;i<=nums[ind];i++){
            if(ind+i<nums.length)
                min=Math.min(min,1+jump(ind+i,nums,dp,min));
        }
        dp[ind]=min;
        return min;
    }
}
