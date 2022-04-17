public class MiinimumSubsetSumDifference {

    //plain recursiob, TIme complexity => 2^n
    public int minDiff(int nums[], int sum, int subsetsum, int n){
        if(n==0){
            return Math.abs((sum-subsetsum)-subsetsum);
        }

        return Math.min(
            minDiff(nums,sum,subsetsum+nums[n-1],n-1), //include
            minDiff(nums, sum, subsetsum, n)    // do not include
        );
    }
    
    public int minimumSubsetSumDiff(int nums[]){
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        return minDiff(nums, sum, 0, nums.length);
    }
}
