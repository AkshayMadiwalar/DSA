package SDE.BinarySearch;

public class FirstAndLastElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0]=findFirst(nums,target);
        ans[1]=findLast(nums,target);
        return ans;
    }
    
    public int findFirst(int[] nums,int target){
        int l = 0;
        int h = nums.length-1;
        int ind = -1;
        while(l<=h){
            int mid = (h+l)/2;
            if(nums[mid]>=target){
                h=mid-1;
            }else{
                l=mid+1;
            }
            
            if(nums[mid]==target)
                ind = mid;
        }
        return ind;
    }
    
    public int findLast(int[] nums,int target){
        int l = 0;
        int h = nums.length-1;
        int ind = -1;
        while(l<=h){
            int mid = (h+l)/2;
            if(nums[mid]<=target){
                l=mid+1;
            }else{
                h=mid-1;
            }
            
            if(nums[mid]==target)
                ind = mid;
        }
        return ind;
    }
}
