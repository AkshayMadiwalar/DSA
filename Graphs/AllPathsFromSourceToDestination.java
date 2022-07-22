package Graphs;

import java.util.*;

public class AllPathsFromSourceToDestination {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        int n = graph.length-1;
        int[] visited = new int[n+1];
        path.add(0);
        dfs(0,graph,visited,n,path);
        return ans;
    }
    
    public void dfs(int node,int[][] adj,int[] visited,int n,List<Integer> path){
        
        if(node==n){
            ans.add(new ArrayList<>(path));
            return;
        }
        
        int[] adjList = adj[node];
        for(int i =0;i<adjList.length;i++){
            int each = adjList[i];
            if(visited[each]==0){
                visited[each]=1;
                path.add(each);
                dfs(each,adj,visited,n,path);
                path.remove(path.size()-1);
                visited[each]=0;
            }
        }
    }
}
