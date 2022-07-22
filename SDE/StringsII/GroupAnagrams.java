package SDE.StringsII;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<Integer>> map = new HashMap<>();
        
        List<List<String>> ans = new ArrayList<>();
        
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(map.containsKey(sorted)){
                List<Integer> indexes = map.get(sorted);
                indexes.add(i);
                map.put(sorted,indexes);
            }else{
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                map.put(sorted,indexes);
            }
        }
        
        for (Map.Entry<String,List<Integer>> entry : map.entrySet()){
            List<String> res = new ArrayList<>();
            List<Integer> ind = entry.getValue();
            for(int i=0;i<ind.size();i++){
                res.add(strs[ind.get(i)]);
            }
            ans.add(res);
        }
        
        return ans;
    }
}
