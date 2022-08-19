package SDE.Strings;

import java.util.*;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int len = 0;
        int evens = 0;
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()%2!=0)
                len+=entry.getValue()-1;
            else{
                len+=entry.getValue();
                evens++;
            }
        }
        
        return map.size()==evens?len:len+1;
    }
}
