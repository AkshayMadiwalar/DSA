package SDE.ArraysII;

public class RotateArrayKTimes {
    public void rotate(int[] nums, int k) {
        
        // while(k>0){
        // int last = nums[nums.length-1];
        // for(int i=nums.length-1;i>0;i--){
        //     nums[i]=nums[i-1];
        // }
        // nums[0]=last;
        // k--;
        // }
        if(nums.length==1)
            return;
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
    }
    
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int t = nums[start];
            nums[start]=nums[end];
            nums[end]=t;
            start++;
            end--;
        }
    }
}
