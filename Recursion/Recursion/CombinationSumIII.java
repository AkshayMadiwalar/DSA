package Recursion;

import java.util.*;

public class CombinationSumIII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        int[] nums = new int[9];
        for(int i=0;i<9;i++){
            nums[i]=i+1;
        }

        List<Integer> ds = new ArrayList<>();
        combination(0,nums,n,k,ds);
        return ans;
    }
    
    public void combination(int ind,int[] nums,int target,int k,List<Integer> ds){
        
        if(target==0){
            if(ds.size()==k)
                ans.add(new ArrayList<>(ds));
                return;
        }
        
        for(int i=ind;i<nums.length;i++){
            if(nums[i]>target)
                break;
                
            ds.add(nums[i]);
            combination(i+1,nums,target-nums[i],k,ds);
            ds.remove(ds.size()-1);
        }
    }
}
