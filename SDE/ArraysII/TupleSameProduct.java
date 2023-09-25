package SDE.ArraysII;

import java.util.HashMap;

public class TupleSameProduct {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int prod = nums[i]*nums[j];
                ans=ans+8*map.getOrDefault(prod,0);
                map.put(prod,map.getOrDefault(prod,0)+1);
            }
        }
        
        return ans;
    }
}
