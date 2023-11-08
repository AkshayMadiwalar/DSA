class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol =0;
        for(int i=0;i<stones.length;i++){
            maxRow=Math.max(maxRow,stones[i][0]);
            maxCol=Math.max(maxCol,stones[i][1]);
        }
        DisJointSet ds = new DisJointSet(maxRow+maxCol+1);
        HashMap<Integer,Integer> nodes = new HashMap<>();
        for(int i=0;i<stones.length;i++){

            int rowNode = stones[i][0];
            int colNode = stones[i][1]+maxRow+1;

            ds.UnionBySize(rowNode,colNode);
            nodes.put(rowNode,1);
            nodes.put(colNode,1);
        }

        int cnt = 0;

        for(Map.Entry<Integer,Integer> it: nodes.entrySet()){
            if(ds.findUParent(it.getKey()) == it.getKey()){
                cnt++;
            }
        }

        int total_stones = stones.length;
        return total_stones - cnt;
    }
}


class DisJointSet{
    int[] parent;
    int[] size;

    DisJointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        Arrays.fill(size,1);
    }

    int findUParent(int node){
        if(node == parent[node])
            return node;
        int up = findUParent(parent[node]);
        parent[node] = up;
        return up;
    }

    void UnionBySize(int u, int v){
        int up_u = findUParent(u);
        int up_v = findUParent(v);

        //both belong to same components
        if(up_u == up_v)
            return;
        
        int u_size=size[up_u];
        int v_size=size[up_v];

        if(u_size<v_size){
            parent[up_u]=up_v;
            size[up_v]+=size[up_u];
        }
        else if(u_size>v_size){
            parent[up_v]=up_u;
            size[up_u]+=size[up_v];
        }
        else{
            parent[up_v]=up_u;
            size[up_u]+=size[up_v];
        }
    }
}