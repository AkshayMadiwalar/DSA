package SDE.HeapsAndPriorityQueue;

import java.util.*;

class Task {
    char id;
    int freq;
    int notAvailableTillTime;
    
    Task(char id, int freq) {
        this.id = id;
        this.freq = freq;
        this.notAvailableTillTime = 0;
    }
}

public class TaskSchedule {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charCount = new HashMap<>();
        
        for(char ch : tasks) {
            int count = charCount.getOrDefault(ch, 0);
            charCount.put(ch, count + 1);
        }
        
        // max Heap
        Queue<Task> pq = new PriorityQueue<>((t1, t2) -> t2.freq - t1.freq);
        for(char ch : charCount.keySet()) {
            pq.add(new Task(ch, charCount.get(ch)));
        }
        
        int time = 0;
        Queue<Task> coolDownQ = new LinkedList<>();
        
        while(!pq.isEmpty() || !coolDownQ.isEmpty()) {
            
            time++;
            
            Task curTask = pq.poll();
            
            if(curTask != null) {
                curTask.freq--;
                
                // cur task not completed
                if(curTask.freq > 0) {
                    // add it to cool down q
                    curTask.notAvailableTillTime = time + n;
                    coolDownQ.add(curTask);
                }
            }
            
            Task coolDownTask = coolDownQ.peek();
            
            if(coolDownTask != null) {
                
                if(coolDownTask.notAvailableTillTime <= time) {
                    coolDownQ.remove();
                    pq.add(coolDownTask);
                }
            }
            
        }
        
        return time;
    }
}
