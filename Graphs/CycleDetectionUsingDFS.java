package Graphs;

import java.util.ArrayList;

public class CycleDetectionUsingDFS {
  
    boolean[] visited;

    public boolean checkForCycle(int node,int parent,boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(Integer it: adj.get(node)){
            if(visited[it] == false){
                checkForCycle(it,node, visited, adj);
            }
            else if(visited[it] == true && parent!=node){
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        visited = new boolean[V];
        for(int i=1;i<=V;i++){
            if(visited[i]==false){
                if(checkForCycle(i, -1,visited, adj))
                    return true;
            }
        }    
        return false;
    }
}
