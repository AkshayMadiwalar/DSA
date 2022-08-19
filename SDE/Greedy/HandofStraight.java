package SDE.Greedy;

import java.util.PriorityQueue;

public class HandofStraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
     
         for(int ele:hand){
             pq.add(ele);
         }
         
         
         
         while(pq.size()>0){
             int s = pq.poll();
             for(int k=1;k<groupSize;k++){
                 if(pq.remove(s+k))
                     continue;
                 else
                     return false;
             }
         }
         
         return true;
     }
}
