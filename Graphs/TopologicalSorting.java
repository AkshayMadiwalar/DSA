import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {

    Stack<Integer> stack = new Stack<Integer>();

    public void dfs(ArrayList<ArrayList<Integer>> adj,int i,int visited[],Stack<Integer> stack){
        visited[i] = 1;
        for(Integer each_adjacent: adj.get(i)){
            if(visited[each_adjacent]==-1){
                dfs(adj,each_adjacent,visited,stack);
            }
        }
        stack.push(i);
    }
    
    public void topoSort(ArrayList<ArrayList<Integer>> adj,int V){
       
        int visited[] = new int[V];

        for(int i=1;i<=V;i++){
            visited[i] =-1;
        }

        for(int i =1;i<=V;i++){
            if(visited[i]!=-1){
                dfs(adj,i,visited,stack);
            }
        }

        //Print stack content -> contains topological sort order
    }
}
