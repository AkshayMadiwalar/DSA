import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {

    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj,int i,int visited[], int dfs_visited[]){
        visited[i] = 1;
        dfs_visited[i] = 1;

        for(Integer each_adjacent: adj.get(i)){
            if(visited[each_adjacent] == 0){
                if(isCycle(adj, i, visited, dfs_visited))
                    return true;
            }
            else if(visited[each_adjacent]==1 && dfs_visited[each_adjacent]==1){
                return true;
            }
        }

        //returning back
        dfs_visited[i] = 0;
        return false;
    }
    
    public boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int n){
        int visited[] = new int[n];
        int dfs_visited[] = new int[n];

        for(int i=1;i<=n;i++){
            visited[i]=0;
            dfs_visited[i]=0;
        }

        for(int i=1;i<=n;i++){
            if(visited[i]==0){
                if(isCycle(adj,i,visited,dfs_visited))
                    return true;
            }
        }

        return false;
    }
}
