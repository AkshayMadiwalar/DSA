package SDE.StackAndQueueII;

import java.util.*;

public class MinStack {
    Stack<List<Integer>> stack;
    int min;
    
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min=Math.min(val,min);
        List<Integer> list = new ArrayList<>();
        list.add(val);
        list.add(min);
        stack.push(list);
    }
    
    public void pop() {
        stack.pop();
        if(stack.size()==0)
            min=Integer.MAX_VALUE;
        else{
            min=stack.peek().get(1);
        }
    }
    
    public int top() {
        List<Integer> list = stack.peek();
        return list.get(0);
    }
    
    public int getMin() {
        List<Integer> list = stack.peek();
        return list.get(1);
    }
}
