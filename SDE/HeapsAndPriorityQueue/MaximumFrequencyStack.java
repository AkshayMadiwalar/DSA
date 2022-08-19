package SDE.HeapsAndPriorityQueue;

import java.util.*;

public class MaximumFrequencyStack {
    class FreqStack {
    
        HashMap<Integer,Integer> map;
        PriorityQueue<Element> pq;
        int index;
    
        public FreqStack() {
            map = new HashMap<Integer,Integer>();
            pq = new PriorityQueue<>(
                (a,b)-> a.freq == b.freq ? b.ind-a.ind : b.freq-a.freq);
            index=0;
        }
        
        public void push(int val) {
            map.put(val,map.getOrDefault(val,0)+1);
            Element element = new Element(val,map.get(val),index++);
            pq.offer(element);
        }
        
        public int pop() {
            map.put(pq.peek().val,map.get(pq.peek().val)-1);
            return pq.poll().val;
        }
    }
    
    class Element{
        public int val;
        int freq;
        int ind;
        Element(int val,int freq,int ind){
            this.val =val;
            this.freq=freq;
            this.ind =ind;
        }
    }
    
}
