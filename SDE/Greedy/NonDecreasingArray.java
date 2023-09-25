package SDE.Greedy;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        
        int c=0;
        int max=nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                
                if(i>1 && nums[i-2]<nums[i]) nums[i-1]=nums[i];
                else if(i>1 && nums[i-2]>nums[i]) nums[i]=nums[i-1];
                
                c++;
                if(c>1)
                    return false;
            }
        }
        
        if(c<=1)    return true;
        return false;
    }
}
