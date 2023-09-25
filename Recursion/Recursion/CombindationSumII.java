package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombindationSumII {
    
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public void findCombinations(int index, int[] candidates, int target, List<Integer> ds){
       if(target == 0){
            ans.add(new ArrayList<>(ds));
           return;
       } 
        
       for(int i=index;i<candidates.length;i++){
           if(i>index && candidates[i]==candidates[i-1])
               continue;
           if(candidates[i] > target)
               break;
           ds.add(candidates[i]);
           findCombinations(i+1,candidates,target-candidates[i],ds);
           ds.remove(ds.size()-1);
       } 
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,new ArrayList<>());
        return ans;
    }
}
