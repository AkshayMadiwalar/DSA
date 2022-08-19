package SDE.ArraysII;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = 0;
        
        while(j<nums.length){
            if(nums[j]%2==0){
                int t = nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                i++;
                j++;
            }
            else{
               j++; 
            }
        }
        
        return nums;
    }
}
