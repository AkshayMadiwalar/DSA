package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class BFS {
    

    public void bfs(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];

        ArrayList<Integer> bfs = new ArrayList<>();

        for(int i =1;i<=V;i++){
            if(visited[i] == false){
                visited[i] = true;

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                while(!queue.isEmpty()){
                    Integer node = queue.poll();

                    bfs.add(node);

                    for(Integer each_adjacent: adj.get(node)){
                        if(visited[each_adjacent] == false){
                            visited[each_adjacent]= true;
                            queue.add(each_adjacent);
                        }
                    }
                }
                
            }
        }

        //bfs array contains the bfs traversal of the graph
    }
}
