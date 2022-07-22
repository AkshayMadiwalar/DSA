package SDE.HeapsAndPriorityQueue;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i]))
                map.put(words[i],1);
            else
                map.put(words[i],map.get(words[i])+1);
        }
        PriorityQueue<Pair<String,Integer>> pq = new PriorityQueue<Pair<String,Integer>>((a,b)-> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k)
                pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while(pq.size()>0)
            ans.add(0,pq.poll().getKey());
        return ans;
    }
}


//   (a,b)-> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()