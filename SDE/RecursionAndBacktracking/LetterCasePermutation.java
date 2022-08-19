package SDE.RecursionAndBacktracking;

import java.util.*;

public class LetterCasePermutation {
    List<String> ans = new ArrayList<>();
    
    public List<String> letterCasePermutation(String s) {
        perm(new StringBuilder(s),0);
        return ans;
    }
    
    
    public void perm(StringBuilder sb,int ind){
        if(ind==sb.length()){
            //compute answer
             ans.add(sb.toString());
            return;
        }
        
        if(Character.isDigit(sb.charAt(ind))){
            perm(sb,ind+1);
        }
        else{
            
            char c = sb.charAt(ind);
            
          
            //lowercase
                sb.setCharAt(ind,Character.toUpperCase(c));
                perm(sb,ind+1);
                sb.setCharAt(ind,c);
            
            
          
            //uppercase
                sb.setCharAt(ind,Character.toLowerCase(c)); 
                perm(sb,ind+1);
                sb.setCharAt(ind,c);
            
        }
    }
}
