package Graphs;

import java.util.ArrayList;

public class NumberOfConnectedComponents {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int[] visited = new int[V];
        int c=0;
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                c++;
                dfs(i,adj,visited,V);
            }
        }
        
        return c;
    }
    
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,int V){
        visited[node]=1;
        
        for(int i=0;i<V;i++){
            if(adj.get(node).get(i)==1)
                if(visited[i]==0){
                    visited[i]=1;
                    dfs(i,adj,visited,V);
                }
        }
    }
}
