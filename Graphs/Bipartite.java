import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite{

    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj,int i, int color[]){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        color[i] = 1;

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            for(Integer each_adjacent:adj.get(node)){
                if(color[each_adjacent] == -1){
                    color[each_adjacent] = 1 - color[node];
                    queue.add(each_adjacent);
                }else if(color[each_adjacent] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBipartite(ArrayList<ArrayList<Integer>> adj,int n){
        int color[] = new int[n];
        for(int i=1;i<=n;i++){
            color[i]=-1;
        }
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!isBipartite(adj,i,color))
                    return false;
            }
        }
        return true;
    }
}