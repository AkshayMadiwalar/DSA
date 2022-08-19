package Graphs;

import java.util.*;

public class RedundantConnection {
    int[] ans = new int[2];
    
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<=edges.length;i++){
           adj.add(new ArrayList<>());
        }
        
       
        
        for(int i=0;i<edges.length;i++){
           adj.get(edges[i][0]).add(edges[i][1]);
           adj.get(edges[i][1]).add(edges[i][0]);
            
           int[] visited = new int[edges.length+1];
            
           if(checkCycle(adj,edges[i][0],-1,visited)){
               ans[0]=edges[i][0];
               ans[1]=edges[i][1];
               return ans;
           }
        }
        
        return new int[]{};
    }
    
    public boolean checkCycle(List<List<Integer>> adj,int node, int parent, int[] visited){
        visited[node]=1;
        for(Integer each: adj.get(node)){
            if(visited[each]==1 && each!=parent)
                return true;
            if(visited[each]==0)
                if(checkCycle(adj,each,node,visited))
                    return true;
        }
        return false;
    }
}
