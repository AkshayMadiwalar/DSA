// COnstant weights

class Solution {
    class Pair{
        int node;
        int distance;
        
        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        } 
    }
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<m; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int ans[] = new int[n];
        for(int i=0; i<n; i++) ans[i] = (int)(1e9);
        
        ans[src] = 0;
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(src, 0));
        
        while(!q.isEmpty()){
            Pair curr = q.remove();
            int node = curr.node;
            int dist = curr.distance;
            ans[node] = dist;
            
            for(int it : adj.get(node)){
                if(dist < ans[it]){
                    ans[it] = dist;
                    q.add(new Pair(it, dist+1));
                }
            }
        }
        
        for(int i=0; i<ans.length; i++){
            if(ans[i] == (int)(1e9)){
                ans[i] = -1;
            }
        }
        
        return ans;
    }
}