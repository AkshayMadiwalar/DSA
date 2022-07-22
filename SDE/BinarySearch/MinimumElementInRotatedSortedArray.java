package SDE.BinarySearch;

public class MinimumElementInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<high){
            int mid = (low+high)/2;
            
            //decrease till  mid, increase till high
            if(nums[low]>=nums[mid]&& nums[mid]<=nums[high]){
                high=mid;
            }

            //decrease till  mid, decrease till high
            else if(nums[low]>=nums[mid]&& nums[mid]>=nums[high]){
                low=mid+1;
            }

            //increase till  mid, increase till high
            else if(nums[low]<=nums[mid] && nums[mid]<=nums[high]){
                high=mid;
            }
            
            //incresae till mid, decrease till  high
            else{
                low=mid+1;
            }
        }
        
        return nums[low];
    }
}
