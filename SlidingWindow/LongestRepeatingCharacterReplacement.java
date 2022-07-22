package SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        
        int start = 0;
        int end = 0;
        int maxCount = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        
        while(end<s.length()){
            if(!map.containsKey(s.charAt(end))){
                map.put(s.charAt(end),1);
                maxCount = Math.max(maxCount,1);
            }else{
                int c = map.get(s.charAt(end));
                map.put(s.charAt(end),c+1);
                maxCount = Math.max(maxCount,c+1);
            }

            if(end-start+1 - maxCount <= k){
                max = Math.max(max,end-start+1);
            }
            
            else if(end-start+1 - maxCount>k){
                while(end-start+1-maxCount>k){
                    int c = map.get(s.charAt(start));
                    if(c==1) map.remove(s.charAt(start));
                    else map.put(s.charAt(start),c-1);
                    start++;
                    max = Math.max(max,end-start+1);
                }
            }
            end++;
        }
        
        return max;
    }
}
