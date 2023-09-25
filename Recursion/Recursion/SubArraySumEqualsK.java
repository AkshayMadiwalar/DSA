package Recursion;

import java.util.HashMap;

public class SubArraySumEqualsK {
    int count = 0;
    public int subarraySum(int[] nums, int k) {
        int prefixsum = 0;
        //int[] ps = new int[nums.length];
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
       for(int i=0;i<nums.length;i++){
           prefixsum+=nums[i];
           if(map.containsKey(prefixsum-k)){
               count+=map.get(prefixsum-k);
           }
           
           if(map.containsKey(prefixsum)){
               map.put(prefixsum,map.get(prefixsum)+1);
           }
           else{
               map.put(prefixsum,1);
           }
       }
        return count;
    }
}
