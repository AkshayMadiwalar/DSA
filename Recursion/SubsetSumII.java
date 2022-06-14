package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumII {
    List<List<Integer>> ans = new ArrayList<>();
    

    //O(2N + nlongn)
    public void findSubsets(int index, int[] nums, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])
                continue;
            ds.add(nums[i]);
            findSubsets(i+1,nums,ds);
            ds.remove(ds.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        findSubsets(0,nums,new ArrayList<>());
        return ans;
    }
}
