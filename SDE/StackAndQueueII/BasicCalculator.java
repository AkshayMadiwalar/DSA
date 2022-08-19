package SDE.StackAndQueueII;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
     
        if(s.length()==0)
            return 0;
        char op ='+';
        int currNum = 0;
        
        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);
            
            if(Character.isDigit(currentChar)){
                currNum=(currNum*10)+(currentChar-'0');
            }
            
            if(!Character.isDigit(currentChar) 
                    && !Character.isWhitespace(currentChar)
                    || i==s.length()-1){
                if(op=='+')
                    stk.push(+currNum);
                else if(op=='-')
                    stk.push(-currNum);
                else if(op=='*'){
                    stk.push(stk.pop()*currNum);
                }
                else if(op=='/'){
                    stk.push(stk.pop()/currNum);
                }
                    
                op=currentChar;
                currNum=0;
            }
            
            
        }
        
        int res = 0;
        while(stk.size()>0)
            res+=stk.pop();
        
        return res;
    }
}
