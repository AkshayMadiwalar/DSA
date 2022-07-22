package SDE.HeapsAndPriorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortkSortedArray {
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        
        for(int i=0;i<num;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                sorted.add(pq.poll());        
            }
        }
        
        while(pq.size()>0){
            sorted.add(pq.poll());
        }
        
        return sorted;
    }
}
