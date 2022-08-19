package SDE.HeapsAndPriorityQueue;
import java.util.*;

class Pair{
    Character c;
    int count;
    Pair(Character c,int count){
        this.c = c;
        this.count = count;
    }
}
public class ReorganizeString {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->b.count-a.count);
        Queue<Pair> queue = new LinkedList<>();
        
        for(Map.Entry<Character,Integer> entry: map.entrySet())
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty() || !queue.isEmpty()){
            Pair pair = pq.poll();
            
            sb.append(pair.c);
            pair.count--;
            
            if(pair.count>0)
                queue.add(pair);
            
            if(pq.size()==0 && queue.size()>0 && queue.peek().c==pair.c)
                return "";
            
            if(queue.size()>0 && queue.peek().c!=pair.c){
                pq.add(queue.peek());
                queue.poll();
            }
        
        }
        
        return sb.toString();
    }
}
