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


     public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;

        int min = Integer.MAX_VALUE;

        while(l<=h){
            int m = (l+h)/2;

            //everything is sorted
            // first elemnt will be minimum
            if(nums[l]<=nums[h]){
                min = Math.min(min,nums[l]);
                break;
            }

            if(nums[l]<=nums[m]){
                min = Math.min(min,nums[l]);
                l=m+1;
            }
            else{
                min = Math.min(min,nums[m]);
                h=m-1;
            }
        }

        return min;
    }
}
