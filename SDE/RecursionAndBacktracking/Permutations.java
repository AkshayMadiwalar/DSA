package SDE.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Permutations {
    public void swap(int[] nums, int i , int index){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
    
      public void perm2(int index, int[] nums, List<List<Integer>> ans){
        
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=index;i<nums.length;i++){
           swap(nums,i,index);
            perm2(index+1,nums,ans);
            swap(nums,i,index);
        }
    }
    
    
    
    public void perm(int[] nums, List<List<Integer>> ans, List<Integer> ds, HashMap<Integer,Integer> map){
        
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(i)){
                map.put(i,1);
                ds.add(nums[i]);
                perm(nums,ans,ds,map);
                ds.remove(ds.size()-1);
                map.remove(i);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
       // perm(nums,ans,new ArrayList<>(),map);
        perm2(0,nums,ans);
        return ans;
    }
}
