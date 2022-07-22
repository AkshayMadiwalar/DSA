package SDE.HeapsAndPriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>(k,(a,b)->a.getKey()-b.getKey());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getValue(),entry.getKey()));
            if(pq.size()>k)
                pq.poll();
        }
        
        int i=0;
        int[] arr = new int[pq.size()];
        while(pq.size()>0){
            arr[i]=pq.poll().getValue();
            i++;
        }
        return arr;
    }
}
