package SDE.StackAndQueueII;

import java.util.HashSet;
import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stk = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        
        if(num.length()==k)
            return "0";
        
        for(int i=0;i<num.length();i++){
            if(stk.size()==0){
                stk.push(i);
                continue;
            }
            while(stk.size()>0 && k!=0 && num.charAt(stk.peek())-'0'>num.charAt(i)-'0'){
                int ind = stk.pop();
                set.add(ind);
                k--;
                if(k==0)
                    break;
            }
            stk.push(i);
            if(k==0) break;
        }
        
        int i=num.length()-1;
        while(k>0){
            if(!set.contains(i)){
                set.add(i);
                k--;
            }
            i--;
        }
        
        String res = "";
        for(int j=0;j<num.length();j++){
            if(!set.contains(j)){
                if(res=="" && num.charAt(j)=='0')
                    continue;
                res+=num.charAt(j);
            }
        }
        return res==""?"0":res;
    }
}
