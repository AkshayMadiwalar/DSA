public class NextPermutation {
    public void nextPermutation(int[] nums) {
        
        int i = nums.length - 2;
        int j = nums.length -1;
      
        //search from back, element smaller to last elment.
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        
        if(i>=0){
            //search from back, element greater than the smaller one found above.
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
        }

    
        
        //reverse
        int start = i+1;
        int end = nums.length-1;

        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
