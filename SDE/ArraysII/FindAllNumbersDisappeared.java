package SDE.ArraysII;

import java.util.*;

public class FindAllNumbersDisappeared {
    

    // O(n) time and O(1) space

    /*
     * For each number i in nums,
we mark the number that i points as negative.
Then we filter the list, get all the indexes
who points to a positive number.
Since those indexes are not visited.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            int ind = Math.abs(nums[i])-1;
            nums[ind]=nums[ind]>0?-nums[ind]:nums[ind];
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                ans.add(i+1);
        }
        
        return ans;
        
    }
}
