package SDE.StackAndQueueII;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].length()>1 || tokens[i].charAt(0)-'0'>=0 && tokens[i].charAt(0)-'0'<=9){
                stk.push(Integer.parseInt(tokens[i]));
            }
            else{
                int second=stk.pop();
                int first = stk.pop();
                if(tokens[i].equals("+"))
                    stk.push(first+second);
                else if(tokens[i].equals("-"))
                    stk.push(first-second);
                else if(tokens[i].equals("*"))
                    stk.push(first*second);
                else if(tokens[i].equals("/"))
                    stk.push(first/second);
            }
        }
        
        return stk.pop();
    }
}
