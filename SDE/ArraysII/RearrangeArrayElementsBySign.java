public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        
        int[] pos = new int[nums.length/2];
        int[] neg = new int[nums.length/2];
        
        int p_index = 0;
        int n_index = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pos[p_index] = nums[i];
                p_index++;
            }else{
                neg[n_index] = nums[i];
                n_index++;
            }
        }
  
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i] = pos[i/2];
            }else{
                nums[i] = neg[i/2];
            }
        }
        
        return nums;
    }
}
