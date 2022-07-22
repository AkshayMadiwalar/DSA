package Graphs;

import java.util.*;

public class CourseScheduleII {
    List<Integer> ans = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        } 
        
        int vis[] = new int[numCourses];
        int dfs_vis[] = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0)
                if(dfs(i,vis,dfs_vis,adj)==true){
                    return new int[]{};
                }
        }
        
        int res[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
    
    public boolean dfs(int node,int vis[],int dfs_vis[],ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        dfs_vis[node]=1;
        for(Integer each:adj.get(node)){
            if(vis[each]==0){
                if(dfs(each,vis,dfs_vis,adj))
                    return true;
            }
            else if(dfs_vis[each]==1)
                return true;
        }
        ans.add(node);
        dfs_vis[node]=0;
        return false;
    }
    
}
