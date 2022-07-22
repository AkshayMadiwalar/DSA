package SDE.ArraysII;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        int num=n;
        set.add(n);
        if(n==1)
            return true;
        while(true){
            n=num;
            int s=0;
            while(n>0){
                int digit = n%10;
                s=s+(int)Math.pow(digit,2);
                n=n/10;
            }
            num=s;
            if(set.contains(s)){
                return false;
            }else{
                set.add(s);
            }
            if(s==1)
                return true;
        }
    }
}
