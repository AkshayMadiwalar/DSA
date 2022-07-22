package Graphs;

import java.util.ArrayList;

public class DFS {


    ArrayList<Integer> storedfs = new ArrayList<>();

    public void dfs(boolean[] visited,int i, ArrayList<ArrayList<Integer>> adj){
        storedfs.add(i);
        visited[i] = true;
        for(Integer each_adjacent: adj.get((i))){
            if(visited[each_adjacent]==false){
                dfs(visited, each_adjacent, adj);
            }
        }
    }

    public void dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj ){
        boolean[] visited = new boolean[V];

        for(int i=1;i<=V;i++){
            if(visited[i]==false){
                dfs(visited,i,adj);
            }
        }
    }

    
}
