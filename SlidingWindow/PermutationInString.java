package SlidingWindow;

import java.util.HashMap;

public class PermutationInString {
    
    public boolean checkInclusion(String s2, String s1) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start=0;
        int end=0;
        int count=0;
    
        for(int i=0;i<s2.length();i++){
            if(!map.containsKey(s2.charAt(i))){
                map.put(s2.charAt(i),1);
                count=count+1;
            }
            else{
                int c=map.get(s2.charAt(i))+1;
                map.put(s2.charAt(i),c);
            }
        }
        
        while(end<s1.length()){
            if(map.containsKey(s1.charAt(end))){
                int c = map.get(s1.charAt(end))-1;
                map.put(s1.charAt(end),c);
                if(c==0){
                    count=count-1;
                }
            }
            
            if(end-start+1<s2.length())
                end++;
            else if(end-start+1==s2.length()){
                if(count==0)
                    return true;
                if(map.containsKey(s1.charAt(start))){
                    int c = map.get(s1.charAt(start))+1;
                    map.put(s1.charAt(start),c);
                    if(c==1)    count++;
                }
                start++;
                end++;
            }
        }
        
        return false;
    }
}
