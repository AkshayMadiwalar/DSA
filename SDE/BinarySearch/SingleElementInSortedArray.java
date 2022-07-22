package SDE.BinarySearch;

public class SingleElementInSortedArray {
    
    //O(logN) time O(1) space
    public int singleNonDuplicate(int[] nums) {
        int l=0;
        int h=nums.length-1;
        
        while(l<h){
            int m=(l+h)/2;
            
           if(m%2==1)   m--;
            
            if(nums[m]!=nums[m+1])
                h=m;
            else if(nums[m]==nums[m+1])
                l=m+2;
        }
        
        return nums[l];
    }
}
