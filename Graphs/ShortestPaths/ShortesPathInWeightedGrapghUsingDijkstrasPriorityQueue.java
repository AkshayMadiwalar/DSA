class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.

    // Varying weights
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->a.dist-b.dist);
        
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        
        dist[S]=0;
        pq.add(new Pair(0,S));
        
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int cur_dist = pair.dist;
            int node = pair.node;
            
            ArrayList<ArrayList<Integer>> adj_nodes = adj.get(node);
            
            for(ArrayList<Integer> adj_node: adj_nodes){
                int v = adj_node.get(0);
                int d = adj_node.get(1);
                
                if(d+cur_dist < dist[v]){
                    dist[v] = d+cur_dist;
                    pq.add(new Pair(d+cur_dist, v));
                }
            }
        }
        
        for(int i=0;i<dist.length;i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        
        return dist;
    }
}



class Pair{
    int dist;
    int node;
    Pair(int dist, int node){
        this.dist=dist;
        this.node=node;
    }
}
