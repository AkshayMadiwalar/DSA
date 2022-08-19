package SlidingWindow;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int start = 0;
        int end = 0;
        
        int prod = 1;
        
        int ans = 0;
        
        if(k<=1)
            return 0;
        
        while(end<nums.length){
            prod*=nums[end];
            
            while(prod>=k){
                prod/=nums[start];
                start++;
            }
            
            ans = ans + end-start+1;
            end++;
        }
        
        return ans;
    }
}
