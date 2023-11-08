class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<int[]>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        Queue<Pair> pq = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        pq.add(new Pair(src,0,0));


        while(pq.size()>0){
            Pair pair = pq.poll();
            int node = pair.node;
            int stops = pair.stops;
            int cur_price = pair.price;
            
            if(stops > k) 
                continue;

            List<int[]> node_adj = adj.get(node);
            for(int[] each_adj: node_adj){
                int v = each_adj[0];
                int p = each_adj[1];
                if(cur_price+p<dist[v]){
                    dist[v]=cur_price+p;
                    pq.add(new Pair(v,dist[v],1+stops));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}

class Pair{
    int stops;
    int price;
    int node;
    Pair(int node, int price, int stops){
        this.node = node;
        this.price = price;
        this.stops  =stops;
    }
}