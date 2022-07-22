package SDE.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsing2Queue {
    
}

class MyStack {
    
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        if(q1.size()==0){
            q1.add(x);
            return;
        }
        while(q1.size()>0)
            q2.add(q1.poll());
        q1.add(x);
        while(q2.size()>0)
            q1.add(q2.poll());
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

