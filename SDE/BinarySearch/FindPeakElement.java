

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        //         int peak = -1;
                
        //         if(nums.length==1)
        //             return 0;
                
        //         if(nums.length==2){
        //             int m = Math.max(nums[0],nums[1]);
        //             return nums[0]==m?0:1;
        //         }
                
        //         for(int i=0;i<nums.length;i++){
        //             if(i==0){
        //                 if(nums[i]>nums[i+1])
        //                         peak=Math.max(peak,i);
        //                 continue;
        //             }
        //             if(i==nums.length-1){
        //                 if(nums[i]>nums[i-1])
        //                     peak=Math.max(peak,i);
        //                 continue;
        //             }
        //             if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
        //                 peak=Math.max(peak,i);
        //         }
        //         return peak;
                return findPeak(nums);
            }
            
            
            public int findPeak(int[] nums){
                int l=0;
                int h = nums.length-1;
                
                while(l<h){
                    int mid = l+(h-l)/2;
                    if(l==h)
                        break;
                    if(nums[mid]>nums[mid+1])
                        h=mid;
                    else
                        l=mid+1;
                }
                
                return l;
            }
}
