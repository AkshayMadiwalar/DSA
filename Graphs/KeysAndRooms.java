package Graphs;

import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms,0,visited);
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false)
                return false;
        }
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, int node, boolean[] visited){
        visited[node]=true;
        
        for(Integer each: rooms.get(node)){
            if(visited[each]==false){
                dfs(rooms,each,visited);
            }
        }
    }
}
