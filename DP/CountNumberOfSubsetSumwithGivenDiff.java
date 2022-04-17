public class CountNumberOfSubsetSumwithGivenDiff {
    
    public int countSubsetSum(int nums[],int n, int subsetsum){
        if(subsetsum == 0){
            return 1;
        }
        if(n==0){
            return 0;
        }

        if(nums[n-1]<=subsetsum){
            return countSubsetSum(nums,n-1,subsetsum-nums[n-1]) + countSubsetSum(nums, n-1, subsetsum);
        }

        return countSubsetSum(nums, n-1, subsetsum);
    }
    public int countNoOfSubsetSumWithGIvenDiff(int nums[],int diff){

        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        // s1 -s2 = diff
        // s1 +s2 = sum
        // 2s1 = diff + sum
        // s1 = (diff + sum) /2;
        int subsetsum = (diff + sum)/2;

        //count the number of subsetsum 
        return countSubsetSum(nums,nums.length,subsetsum);
    }
}
