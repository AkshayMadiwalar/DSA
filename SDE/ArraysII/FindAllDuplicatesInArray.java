package SDE.ArraysII;

import java.util.*;

public class FindAllDuplicatesInArray {

    //O(n) time and O(1) space
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int ind = Math.abs(nums[i])-1;
            if(nums[ind]<0){
                ans.add(Math.abs(nums[i]));
            }else{
                nums[ind] = -nums[ind];
            }
        }
        
        return ans;
    }
}


// 2 3 4 2 1