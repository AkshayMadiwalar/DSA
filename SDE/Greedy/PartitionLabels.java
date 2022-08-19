package SDE.Greedy;

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),i);
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            int e = map.get(s.charAt(i));
            int len=1;
            while(i<e){
                e=Math.max(e,map.get(s.charAt(i)));
                i++;
                len++;
            }
            ans.add(len);
        }
        
        return ans;
    }
}
