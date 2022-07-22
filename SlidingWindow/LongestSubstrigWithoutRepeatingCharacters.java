package SlidingWindow;

import java.util.HashMap;

public class LongestSubstrigWithoutRepeatingCharacters {
    
    static int longestSubstrDistinctChars(String s){
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        int start=0;
        int end=0;
        int max=0;
        
        while(end<s.length()){
            if(!map.containsKey(s.charAt(end)))
                map.put(s.charAt(end),1);
            else{
                int c=map.get(s.charAt(end))+1;
                map.put(s.charAt(end),c);
            }
            
            int window = end-start+1;
            
            if(map.size() == window){
                max=Math.max(max,window);
            }
            
            else if(map.size()<window){
                while(map.size()<end-start+1){
                    int c = map.get(s.charAt(start))-1;
                    map.put(s.charAt(start),c);
                    if(c==0)    map.remove(s.charAt(start));
                    start++;
                }
                max=Math.max(max,end-start+1);
            }
            
            end++;
        }
        
        return max;
    }
}
