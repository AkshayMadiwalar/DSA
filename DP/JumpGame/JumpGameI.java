package DP.JumpGame;

public class JumpGameI {




    // bool canJump(int A[], int n) {
    //     int last=n-1,i,j;
    //     for(i=n-2;i>=0;i--){
    //         if(i+A[i]>=last)last=i;
    //     }
    //     return last<=0;
    // }


    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
       // return jump(0,nums,dp);
        
        dp[nums.length-1]=1;
        for(int ind=nums.length-2;ind>=0;ind--){
            for(int i=1;i<=nums[ind];i++){
                if(ind+i <nums.length && dp[ind]==0)
                    dp[ind]=dp[ind+i];
            }
        }
        return dp[0]==1?true:false;
    }
    
    public boolean jump(int ind,int[] nums,int[] dp){
        
        if(ind==nums.length-1)
            return true;
        
        if(dp[ind]!=0)
            return dp[ind]==1?true:false;
        
        for(int i=1;i<=nums[ind];i++){
            if(jump(ind+i,nums,dp)){
                dp[ind]=1;
                return true;
            }
        }
        dp[ind]=2;
        return false;
    }
}
