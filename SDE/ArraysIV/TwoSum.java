package SDE.ArraysIV;

import java.util.HashMap;

public class TwoSum {

    //Hashing
    //Time O(n)
    //SPace O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int[] ans = new int[2];
        
        for(int i =0;i<nums.length;i++){
            if(map.get(target-nums[i])!=null){
                ans[0]=map.get(target-nums[i]);
                ans[1]=i;
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        
        return ans;
    }
}
