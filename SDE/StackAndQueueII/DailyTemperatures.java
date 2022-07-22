package SDE.StackAndQueueII;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] nge = new int[temperatures.length];
        
        Stack<Integer> stk = new Stack<>();
        
        for(int i=0;i<temperatures.length;i++){
            if(stk.size()==0){
                stk.push(i);
                continue;
            }
            while(stk.size()>0 && temperatures[stk.peek()]<temperatures[i]){
                int ind = stk.peek();
                nge[ind]=i-ind;
                stk.pop();
            }
            stk.push(i);
        }
        
        return nge;
    }
}
