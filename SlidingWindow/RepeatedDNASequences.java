package SlidingWindow;

import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        
        int start = 0;
        int end = 0;
        
        HashSet<String> ans = new HashSet<>();
        
        while(end<s.length()){
            if(end-start+1<10){
                end++;
            }
            else if(end-start+1==10){
                if(set.contains(s.substring(start,end+1))){
                    ans.add(s.substring(start,end+1));
                }
                set.add(s.substring(start,end+1));
                start++;
                end++;
            }
        }
        
        return new ArrayList<>(ans);
        
    }
}
