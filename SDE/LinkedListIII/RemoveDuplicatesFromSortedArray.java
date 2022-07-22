package SDE.LinkedListIII;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        
        int i = 0;
        int j = 1;
        int c = 1;
        
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }
            else{
                i++;
                c++;
                nums[i]=nums[j];
                j++;
            }
        }
        
        return c;
    }
}
