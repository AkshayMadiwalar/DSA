package SDE.StackAndQueue;

import java.util.Stack;

public class ImplementQueueUsing2Stacks {
    
    class MyQueue {
    
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
    
        public MyQueue() {
            
        }
        
        public void push(int x) {
            if(s1.size()==0){
                s1.push(x);
                return;
            }
            while(s1.size()>0){
                s2.push(s1.pop());
            }
            s2.push(x);
            while(s2.size()>0){
                s1.push(s2.pop());
            }
                
        }
        
        public int pop() {
            return s1.pop();
        }
        
        public int peek() {
            return s1.peek();
        }
        
        public boolean empty() {
            return s1.size()==0?true:false;
        }
    }
    
    
    
    
}
