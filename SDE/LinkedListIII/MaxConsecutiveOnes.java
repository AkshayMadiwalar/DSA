package SDE.LinkedListIII;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        if(nums.length==1)
            return nums[0];
        
        int i=0;
        int j=1;
        int max=0;
        int c = 0;
        
        c=nums[i]==1?1:0;
        max=c;
        
        while(j<nums.length){
            if(nums[i]==1 && nums[j]==nums[i]){
                j++;
                c++;
                max=Math.max(max,c);
            }else{
                i=j;
                j++;
                c=nums[i]==1?1:0;
                max=Math.max(max,c);
            }
        }
        
        return max;
    }
}
