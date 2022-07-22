package SDE.StackAndQueueII;

import java.util.Stack;

public class LargestRectangleAreainHistogram {
    
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        
        int[] lse = new int[heights.length];
        int[] rse = new int[heights.length];
        
        for(int i=0;i<heights.length;i++){
        
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            
            if(stack.size()==0){
                lse[i]=0;
            }
            else{
                lse[i]=stack.peek()+1;
            }
            
            stack.push(i);
        }
        
        while(stack.size()>0)
            stack.pop();
        

        for(int i=heights.length-1;i>=0;i--){
 
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.size()==0)
                rse[i]=heights.length-1;
            else
                rse[i]=stack.peek()-1;
            stack.push(i);
           
        }
        
        int m=0;
        
        for(int i=0;i<heights.length;i++){
            m=Math.max(m,(rse[i]-lse[i]+1)*heights[i]);
        }
        
        return m;
    }
}
