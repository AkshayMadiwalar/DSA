package SDE.HeapsAndPriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFInder {
    
    class MedianFinder {

        PriorityQueue<Integer> minpq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        
        public MedianFinder() {
               
        }
        
        public void addNum(int num) {
            maxpq.offer(num);
            minpq.offer(maxpq.poll());
            if(minpq.size() > maxpq.size())
                maxpq.offer(minpq.poll());
        }
        
        public double findMedian() {
            if(maxpq.size()>minpq.size())
                return maxpq.peek();
        
            return (maxpq.peek()+minpq.peek())/2.0d;
        }
    }
}
