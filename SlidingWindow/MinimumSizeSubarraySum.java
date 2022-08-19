package SlidingWindow;

public class MinimumSizeSubarraySum {

    /*
     * 
     * Minimum size with sum Greater thn Or Equal to target
     * 
     */
    public int minSubArrayLen(int target, int[] nums) {
    
        int start = 0;
        int end = 0;
        
        int min  =  (int)Math.pow(10,9);
        
        int sum = 0;
        
        while(end<nums.length){
            sum+=nums[end];
            
            if(sum==target)
                min=Math.min(min,end-start+1);
            
            while(sum>=target){
                    min=Math.min(min,end-start+1);
                    sum-=nums[start];
                    start++;
            }
            
            end++;
        }
        
        return min==(int)Math.pow(10,9)?0:min;
    } 
}
