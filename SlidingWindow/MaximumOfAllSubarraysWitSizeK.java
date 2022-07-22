package SlidingWindow;

import java.util.*;

public class MaximumOfAllSubarraysWitSizeK {

    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int start=0;
        int end=0;
        
        List<List<Integer>> list = new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        
        while(end<nums.length){
            int back=list.size();
            while(list.size()>0 && list.get(back-1).get(0)<nums[end]){
                list.remove(back-1);
                back--;
            }
            
            List<Integer> ar = new ArrayList<>();
            ar.add(nums[end]);
            ar.add(end);
            list.add(ar);
            
            if(end-start+1<k)
                end++;
            else if(end-start+1==k){
                ans.add(list.get(0).get(0));
                if(list.contains(Arrays.asList(nums[start],start))){
                    list.remove(list.indexOf(Arrays.asList(nums[start],start)));
                }
                start++;
                end++;
            }
        }
        
        int[] res= new int[ans.size()];
        for(int i =0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}
