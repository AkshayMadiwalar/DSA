package SDE.BinarySearch;

public class SearchInRotatedArray {
    
    //O(LogN) time //O(1) space
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(nums[mid]==target)
                return mid;
            
         
            //left array is sorted
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && nums[mid]>=target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }

            //left array not sorted
            else{
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                }
                else
                    high=mid-1;
            }
            
        }
        
        return -1;
    }
}
