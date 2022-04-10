package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javafx.scene.Node;

class Pair {
    int node;
    int prev;

    Pair(int f, int s) {
        this.node = f;
        this.prev = s;
    }
}

public class CycleDetectionUsingBFS {

    public boolean isCycle(int source,boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> queue =new LinkedList<>();
            
        //first node, prev = -1
        queue.add(new Pair(source,-1));

        while(!queue.isEmpty()){
            int node = queue.peek().node;
            int prev = queue.peek().prev;

            queue.remove();

            for(Integer each_adjacent: adj.get(node)){
                if(visited[each_adjacent] == false){
                    visited[each_adjacent] = true;
                    queue.add(new Pair(each_adjacent, node));
                }

                else if(visited[each_adjacent] == true && each_adjacent!=prev){
                    //has cycle
                    return true;
                }
            }

        }
        return false;
    }

    public boolean cycleDetection(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        for(int i=1;i<=V;i++){
            if(visited[i]==false){
                return isCycle(i, visited, adj);
            }
        }
        return false;
    }

}
