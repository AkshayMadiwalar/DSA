package SDE.HeapsAndPriorityQueue;

import java.util.*;

public class SortCharacterByFrequency {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->b.count-a.count);
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size()>0){
            Pair pair = pq.poll();
            while(pair.count>0){
                sb.append(pair.c);
                pair.count--;
            }
        }
        
        return sb.toString();
    }
}
