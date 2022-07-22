package SDE.StackAndQueueII;

import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        
        stk.push(0);
        
        int[] ans = new int[nums.length];
        
        for(int i=1;i<nums.length*2;i++){
            if(stk.size()==0){
                stk.push(i%nums.length);
                continue;
            }
            while(stk.size()>0 && nums[stk.peek()]<nums[i%nums.length]){
                ans[stk.pop()%nums.length]=nums[i%nums.length];
            }
            if(i<nums.length) stk.push(i%nums.length);
        }
        
        while(stk.size()>0){
            ans[stk.pop()%nums.length]=-1;
        }

        
        return ans;
    }
}
