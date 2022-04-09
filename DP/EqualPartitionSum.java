package DP;

public class EqualPartitionSum {

    //plain recursion for sbsetsum
    public boolean subset(int[] nums, int n,int sum){
        if(sum==0)  
            return true;
        if(n==0)    
            return false;
        if(nums[n-1]<=sum)
            return subset(nums,n-1,sum) || subset(nums,n-1,sum-nums[n-1]);
        return subset(nums,n-1,sum);  
    }
    
    int[][] dp_memo;
    
    //using DP Memoization => Better time cmplexity
    public int subsetUsingDpMemo(int[] nums, int n,int sum){
        if(sum==0)  
            return 1;
        if(n<=0)    
            return 0;
        
        if(dp_memo[n-1][sum]!=-1){
            return dp_memo[n-1][sum];
        }
        
        if(nums[n-1]<=sum)
            return dp_memo[n][sum] = Math.max(subsetUsingDpMemo(nums,n-1,sum),subsetUsingDpMemo(nums,n-1,sum-nums[n-1]));
        return dp_memo[n][sum] = subsetUsingDpMemo(nums,n-1,sum);  
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        
        if(sum%2 != 0)
            return false;
        
        dp_memo = new int[nums.length+1][sum+1];
        for(int i=0;i<=nums.length;i++){
            for(int j=0;j<=sum;j++){
                dp_memo[i][j] = -1;   
            }
        }
        if(subsetUsingDpMemo(nums,nums.length,sum/2)==1){
            return true;
        }  
        return false;   
    }
}
