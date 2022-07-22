package Recursion;

public class COmbinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
       // Arrays.fill(dp,-1);
       // return comb(nums,target,dp);
        
        dp[0]=1;
        for(int i=1;i<=target;i++)
            for(int j=0;j<nums.length;j++)
                if(i>=nums[j])
                    dp[i]+=dp[i-nums[j]];
        
        return dp[target];
        
    }
    
    public int comb(int[] nums,int target,int[] dp){
        
        if(target==0){
            return 1;
        }
        
        if(dp[target]!=-1)
            return dp[target];
        
        int n=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target)
                n=n+comb(nums,target-nums[i],dp);
        }
        
        dp[target]=n;
        
        return n;
    }
}
