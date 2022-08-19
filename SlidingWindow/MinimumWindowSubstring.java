package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tmap = new HashMap<>();
        for(char each: t.toCharArray()){
            tmap.put(each,tmap.getOrDefault(each,0)+1);
        }
        
        int start = 0;
        int end = 0;
        HashMap<Character,Integer> smap = new HashMap<>();
        
        int req = 0;
        
        int reslen = -1;
        int[] res = {-1,-1};
        
        while(end<s.length()){
            smap.put(s.charAt(end),smap.getOrDefault(s.charAt(end),0)+1);
            
            if(tmap.containsKey(s.charAt(end)) &&
              smap.get(s.charAt(end)).intValue() == tmap.get(s.charAt(end)).intValue()){
                req++;
            }
            
            while(start<=end && req == tmap.size()){
                if(reslen==-1 || reslen> end-start+1){
                    reslen=end-start+1;
                    res[0]=start;
                    res[1]=end;
                }
                if(smap.containsKey(s.charAt(start)))
                    smap.put(s.charAt(start),smap.get(s.charAt(start))-1);
                
                if(tmap.containsKey(s.charAt(start)) && smap.get(s.charAt(start))<tmap.get(s.charAt(start)))
                        req--;
                
                
                start++;
            }
            end++;
        }
        if(reslen==-1)
            return "";
        return s.substring(res[0],res[1]+1);
    }
}
