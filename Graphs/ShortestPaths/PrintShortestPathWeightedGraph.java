

// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        
        int parent[]=new int[n+1];    //memoization
        Arrays.fill(dist,Integer.MAX_VALUE);
        parent[1]=1;
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.add(new Pair(dist[1],1));
        
        while(!pq.isEmpty())
        {
            int node=pq.peek().node;
            int cost=pq.peek().wt;
            pq.poll();
            
            if(cost>dist[node])continue;
            
            for(int[] val:adj.get(node))
            {
                int dest=val[0];
                int destCost=val[1];
                
                int finalCost=Math.min(dist[dest],destCost+cost);
                
                if(finalCost==dist[dest])continue;
                
                dist[dest]=finalCost;
                parent[dest]=node;
                pq.add(new Pair(dist[dest],dest));
                
            }
        }
        
        List<Integer> ans=new LinkedList<>();
        
        if(dist[n]==Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        
        int i=n;
        while(true)
        {
            ans.add(i);
            if(i==1)break;
            i=parent[i];
        }
          
        Collections.reverse(ans); 
        return ans;
    }
}

class Pair
{
    int wt,node;
    Pair(int wt,int node)
    {
        this.wt=wt;
        this.node=node;
    }
}