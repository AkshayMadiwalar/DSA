package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subsetsum = new ArrayList<>();
    

    //Sum of all subsets
    public void subSetSum(int index, int sum, int[] nums){
        if(index == nums.length){
            subsetsum.add(sum);
            return;
        }
        //pick
        subSetSum(index+1,sum+nums[index], nums);

        //not pick
        subSetSum(index+1,sum,nums);
    }

    //Finding all subsets
    // [1,2,3] => [],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]
    public void findAllSubsets(int index, int[] nums, List<Integer> ds){
        if(index == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }    
        //pick
        ds.add(nums[index]);
        findAllSubsets(index+1,nums,ds);
        ds.remove(ds.size()-1);
        findAllSubsets(index+1,nums,ds);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        findAllSubsets(0,nums,new ArrayList<>());
        return ans;
    }
}
