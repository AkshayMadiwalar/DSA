package SDE.HeapsAndPriorityQueue;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        
        while(pq.size()>0){
            if(pq.size()==1)
                break;
            int y = pq.poll();
            int x = pq.poll();
            if(y!=x)
                pq.add(y-x);
        }
        
        return pq.size()==0?0:pq.peek();
    }
}
