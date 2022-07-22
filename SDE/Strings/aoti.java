package SDE.Strings;

import java.util.ArrayList;
import java.util.List;

public class aoti {
    public int myAtoi(String s) {
        
        int sign=1;
        List<Integer> nums = new ArrayList<>();
        boolean start=false;
        
        int ind = 0;
        int base =0;
        
        if(s.length()==0)
            return base;
           
        while(ind<s.length() && s.charAt(ind)==' '){
                ind++;
        }
        
        if(ind<s.length() && (s.charAt(ind)=='-' || s.charAt(ind)=='+')){
            if(s.charAt(ind)=='-')
                sign=-1;
            ind++;
        }
        
        int i = ind;
        
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
            if(base>Integer.MAX_VALUE/10 || 
                (base == Integer.MAX_VALUE/10 && s.charAt(i)-'0'> Integer.MAX_VALUE%10) ){
                 if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            base=10*base+(s.charAt(i)-'0');
            i++;
        }
    
        
        return base*sign;
    }
}
