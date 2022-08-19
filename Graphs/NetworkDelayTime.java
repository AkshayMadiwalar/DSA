package Graphs;

import java.util.*;

public class NetworkDelayTime {
    class Network{
        int node;
        int time;
        Network(int node,int time){
            this.node = node;
            this.time = time;
        }
    }
    
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            List<List<int[]>> adj = new ArrayList<>();
            
            for(int i=0;i<=n;i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<times.length;i++){
                adj.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
            }
            
            PriorityQueue<Network> pq = new PriorityQueue<>((a,b)->a.time-b.time);
            HashMap<Integer,Integer> map = new HashMap<>();
            
            pq.add(new Network(k,0));
            map.put(k,0);
            
           
            
            while(pq.size()>0){
                Network net = pq.poll();
            
                int cur_time = net.time;
                
                if(map.containsKey(net.node) && map.get(net.node)<cur_time)
                    continue;
                
                for(int[] each: adj.get(net.node)){
                    if(map.containsKey(each[0]) && map.get(each[0])<cur_time+each[1])
                        continue;
                        
                    pq.add(new Network(each[0],cur_time+each[1]));
                    map.put(each[0],cur_time+each[1]);
                    
                }
            }
            
            int max = 0;
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                max=Math.max(max,entry.getValue());
            }
            
            //to check if visited all nodes
            if(map.size()!=n)
                return -1;
            
            return max==0?-1:max;
        }
    
    } 
}
