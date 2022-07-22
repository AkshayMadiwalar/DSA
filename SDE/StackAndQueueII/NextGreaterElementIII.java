package SDE.StackAndQueueII;

import java.util.*;

public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        List<Integer> nums = new ArrayList<>();
        
        while(n>0){
            int digit = n%10;
            nums.add(0,digit);
            n=n/10;
        }
        
        int i = nums.size()-2;
        
        while(i>=0 && nums.get(i)>=nums.get(i+1)){
            i--;
        }
        
        int j = nums.size()-1;
        
        if(i<0)
            return -1;
        
        while(j>=0 && nums.get(j)<=nums.get(i)){
            j--;
        }
        
        int temp = nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
            
        
        int start = i+1;
        int end=nums.size()-1;
        
        while(start<end){
            int t = nums.get(start);
            nums.set(start,nums.get(end));
            nums.set(end,t);
            start++;
            end--;
        }
        
        int res = 0;
        for(int k=0;k<nums.size();k++){
            if(res>Integer.MAX_VALUE/10 || 
                res==Integer.MAX_VALUE/10 && nums.get(k)>Integer.MAX_VALUE%10
              )
                return -1;
            res=res*10+nums.get(k);
        }
        
        return res;
    }
}
