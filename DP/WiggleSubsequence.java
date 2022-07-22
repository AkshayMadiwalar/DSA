package DP;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int in=1;
        int d=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])
                in=d+1;
            else if(nums[i]<nums[i-1])
                d=in+1;
        }
        return Math.max(in,d);
    }
}
