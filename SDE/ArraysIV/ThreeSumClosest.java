package SDE.ArraysIV;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int closest = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            
            int start = i+1;
            int end = nums.length-1;
            
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                
                if(sum>target)
                    end--;
                else if(sum < target)
                    start++;
                else{
                    closest = sum;
                    break;
                }
                
                if(closest == Integer.MAX_VALUE)
                    closest = sum;
            
                else if(Math.abs(closest-target)> Math.abs(sum-target))
                    closest = sum;
            }
        }
        
        return closest;
    }
}
