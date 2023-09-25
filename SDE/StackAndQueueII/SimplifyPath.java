package SDE.StackAndQueueII;

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        
        String[] strs = path.split("/");
        for(int i=0;i<strs.length;i++){
            if(!strs[i].equals(".") && !strs[i].equals("") && !strs[i].equals("..")){
                stk.push(strs[i]);
            }
            else if(strs[i].equals("..") && !stk.isEmpty()){
                stk.pop();
            }
        }
        
        String ans = "";
        List<String> res = new ArrayList<>();
        
        while(stk.size()>0){
            res.add(0,stk.pop());
        }
        
        for(String r:res){
            ans+="/";
            ans+=r;
        }
        
        return ans.equals("")?"/":ans;
    }
}
