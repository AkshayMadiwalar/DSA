package SDE.StackAndQueue;

import java.util.Stack;

public class ValidParentheses {
    
     
    public boolean isValid(String str) {
        Stack<Character> s =new Stack<>();
        
       for(char c:str.toCharArray()){
           if(c=='(' )
               s.push(c);
           else if(c=='{')
               s.push(c);
           else if(c=='[')
               s.push(c);
           
           if(s.size()==0)
               return false;
           
           if(c==')'){
               if('('!=s.pop())
                   return false;
           }
           else if(c=='}'){
               if('{'!=s.pop())
                   return false;
           }
            else if(c==']'){
               if('['!=s.pop())
                   return false;
           }
       }
       
       return s.size()==0?true:false;
   }
}
