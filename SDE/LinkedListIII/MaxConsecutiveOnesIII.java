package SDE.LinkedListIII;

public class MaxConsecutiveOnesIII {
    
    public int longestOnes(int[] nums, int k) {
     
        int start=0;
        int end=0;
        int max=0;
        
        while(end<nums.length){
            if(nums[end]==0)
                k--;
            
            if(k>0){
                max=Math.max(max,end-start+1);
                end++;
            }   
            else if(k==0){
                max=Math.max(max,end-start+1);
                end++;
            }
            else{
                while(k<0 && start<end){
                    if(nums[start]==0) k++;
                    start++;
                }
                // max=Math.max(max,end-start+1);
                end++;
            }
            
        }
        return max;
    }
}
