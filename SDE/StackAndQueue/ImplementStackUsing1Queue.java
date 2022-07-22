package SDE.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsing1Queue {
    
}

class MyStack {
    
    Queue<Integer> q1 = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
       if(q1.size()==0){
           q1.add(x);
           return;
       }
        int size = q1.size();
        q1.add(x);
        
        
        while(size>0){
            q1.add(q1.peek());
            q1.poll();
            size--;
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}


