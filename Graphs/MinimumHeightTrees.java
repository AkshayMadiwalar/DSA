package Graphs;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> res = new ArrayList<>();
        
        if(n==0)
            return res;
        if(n==1){
            res.add(0);
            return res;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] degrees = new int[n];
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            degrees[edges[i][0]]++;
            degrees[edges[i][1]]++;
        }
        
        for(int i=0;i<n;i++){
            if(degrees[i]==1){
                queue.add(i);
            }
        }
        
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            res.clear(); //holds inner most nodes
            
            while(size>0){
                Integer node = queue.poll();
                res.add(node);
                for(Integer each: adj.get(node)){
                    degrees[each]--;
                    if(degrees[each]==1){
                        queue.add(each);
                    }
                }
                size--;
            }

            
        }

        return res;
    }
}
