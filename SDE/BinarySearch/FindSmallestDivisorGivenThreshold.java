package SDE.BinarySearch;

public class FindSmallestDivisorGivenThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int min = 1;
        int max = Integer.MIN_VALUE;
        
        for(int num:nums){
            max = Math.max(max,num);
        }
        
        while(min<max){
            int mid = (min+max)/2;
            int result = getResult(nums,mid);
            
            if(result<=threshold){
                max=mid;
            }else{
                min=mid+1;
            }
        }
        
        return max;
    }
    
    public int getResult(int[]  nums, int divisor){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)(nums[i])/(double)(divisor));
        }
        return sum;
    }
}
