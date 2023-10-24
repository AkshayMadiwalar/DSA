package SDE.StackAndQueueII;

import java.util.Stack;

public class BackSpaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray()){
            if(c!='#'){
                stk.push(c);
            }
            else if(stk.size()==0)
                continue;
            else{
                stk.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(stk.size()>0){
            sb.append(stk.pop());    
        }
        
        for(char c: t.toCharArray()){
            if(c!='#'){
                stk.push(c);
            }
            else if(stk.size()==0)
                continue;
            else{
                stk.pop();
                
            }
        }
        
        if(stk.size()!=sb.length())
            return false;
        
        int i = 0;
        
        while(stk.size()>0){
            if(stk.pop()!=sb.charAt(i))
                return false;
            i++;
        }
        
        return true;
        
    }
}
