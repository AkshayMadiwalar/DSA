package SDE.RecursionAndBacktracking;

import java.util.*;

public class GenerateParentheses {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        generate(n,1,0,sb);
        return ans;
    }
    
    
    public void generate(int n, int open, int closed,StringBuilder sb){
        
        if(open==n && closed==n){
            ans.add(sb.toString());
            return;
        }
        //add open
        if(open<=n){
            sb.append('(');
            generate(n,open+1,closed,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        //add close
        if(open>closed){
            sb.append(')');
            generate(n,open,closed+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
