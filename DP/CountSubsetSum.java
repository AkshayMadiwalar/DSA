package DP;

public class CountSubsetSum {
    
    //Recursion, add the subsets results
    public int subsetSum(int[] nums,int n, int sum){
        if(sum == 0){
            return 1;
        }

        if(n <= 0){
            return 0;
        }

        if(nums[n-1]<=sum){
            return subsetSum(nums, n-1, sum) + subsetSum(nums, n-1, sum-nums[n-1]);
        }

        return subsetSum(nums, n-1, sum);
    }
}
