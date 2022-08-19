package SDE.HeapsAndPriorityQueue;

import java.util.*;

public class KClosestPointstoX {
    class Point{
        int dist;
        int key;
        Point(int d,int x){
            this.dist = d;
            this.key = x;
        }
    }
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            
            PriorityQueue<Point> pq = new PriorityQueue<Point>(
                (a,b)->a.dist==b.dist? b.key-a.key : b.dist-a.dist);
            
            for(int i=0;i<arr.length;i++){
                int d = Math.abs(arr[i]-x);
                pq.add(new Point(d,arr[i]));
                if(pq.size()>k)
                    pq.poll();
            }
            
            PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b)->a-b);
            
            while(pq.size()>0)
                pq1.add(pq.poll().key);
            
            List<Integer> ans = new ArrayList<>();
            
            while(pq1.size()>0)
                ans.add(pq1.poll());
            
            return ans;
        }
    }
}
