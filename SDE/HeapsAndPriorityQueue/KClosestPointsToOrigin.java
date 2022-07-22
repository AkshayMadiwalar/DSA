package SDE.HeapsAndPriorityQueue;

import java.util.PriorityQueue;

import javafx.util.Pair;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
     
        PriorityQueue<Pair<Integer,int[]>> pq= new PriorityQueue<Pair<Integer,int[]>>(k,(a,b)->b.getKey()-a.getKey());
        
        for(int i=0;i<points.length;i++){
            int dist = (int)Math.pow(points[i][0],2)+(int)Math.pow(points[i][1],2);
            pq.add(new Pair(dist,new int[]{points[i][0],points[i][1]}));
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int[][] closepoints = new int[pq.size()][2];
        int i=0;
        while(pq.size()>0){
            closepoints[i]=pq.poll().getValue();
            i++;
        }
        return closepoints;
    }
}
