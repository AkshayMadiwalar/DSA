package Graphs;

import java.util.ArrayList;

public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] visited = new int[numCourses];
        int[] dfs_vis = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(checkForCycle(i,visited,dfs_vis,adj))
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean checkForCycle(int node, int[] visited, int[] dfs_vis, ArrayList<ArrayList<Integer>> adj){
        visited[node]=1;
        dfs_vis[node]=1;
        
        for(Integer each: adj.get(node)){
            if(visited[each]==0){
                if(checkForCycle(each,visited,dfs_vis,adj))
                    return true;
            }
            else if(visited[each]==1 && dfs_vis[each]==1)
                return true;
        }
        dfs_vis[node]=0;
        return false;
    }
}
