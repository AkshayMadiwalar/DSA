import java.util.ArrayList;

public class PermutationsOfGivenNumber {
    public int fact(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*fact(n-1);
    }
    public int[] findNextPermutation(int[] nums){
            int i = nums.length-2;
            int j = nums.length -1;
        
            while(i>=0 && nums[i]>=nums[i+1]){
                i--;
            }
        
            if(i>=0){
                while(j>=0 && nums[j]<=nums[i]){
                    j--;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        
            int start = i+1;
            int end = nums.length-1;
        
            while(start<end){
                int temp = nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;
                end--;
            }
        return nums;
    }
    
    // public List<List<Integer>> permute(int[] nums) {
    //     int n = fact(nums.length);
    //     List<List<Integer>> ans = new ArrayList<>();
        
    //     while(n>0){
    //         int[] per = findNextPermutation(nums);
    //         nums = per;
    //         List<Integer> list = new ArrayList<>();
            
    //         for(int i=0;i<per.length;i++){
    //             list.add(per[i]);
    //         }
    //         ans.add(list);
    //         n--;
    //     }
    //     return ans;
    // } 
}
