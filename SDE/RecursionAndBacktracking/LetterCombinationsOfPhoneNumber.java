package SDE.RecursionAndBacktracking;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    List<String> ans = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        
        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        if(digits.length()==0)
            return ans;
        
        func(digits,0,new StringBuilder(),map);
        return ans;
    }
    
    public void func(String digits,int index,StringBuilder sb,HashMap<Integer,String> map){
        
        if(index==digits.length()){
            ans.add(sb.toString());
            return;
        }
            
        int num = digits.charAt(index)-'0';
        
        String s = map.get(num);
        
        int len = 3;
        if(num==7||num==9)
            len=4;
        
        for(int i=0;i<len;i++){
            sb.append(s.charAt(i));
            func(digits,index+1,sb,map);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
