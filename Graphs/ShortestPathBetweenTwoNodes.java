import java.util.ArrayList;
import java.util.Queue;

public class ShortestPathBetweenTwoNodes {
    
    public void shortestPath(ArrayList<ArrayList<Integer>> adj, int N, int src){
        int dist[] = new int[N];
        Queue<Integer> queue = new Queue<>();
        dist[src] = 0;
        queue.add(src);

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            for(Integer each_adj: adj.get(node)){
                if(dist[node]+1 < dist[each_adj]){
                    dist[each_adj] = dist[node] +1;
                    queue.add(each_adj);
                }
            }
        }

        //print dist array => cntains shortest path from src to each node
    }
}
