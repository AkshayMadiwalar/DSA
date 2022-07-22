package SDE.Strings;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b)){
                    continue;
                }
                else
                    return false;
            }
            else{
                if(map.containsValue(b))
                    return false;
                else{
                    map.put(a,b);
                }
            }
        }
        return true;
    }
}
