class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        DisJointSet ds = new DisJointSet(m*n);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 0)
                    continue;
                
                int cellNo = m*i+j;

                int[] dr = {-1,0,1,0};
                int[] cr = {0,1,0,-1};
                boolean adjPresent = false;
                for(int ind=0;ind<dr.length;ind++){
                    int adjRow = i+dr[ind];
                    int adjCol = i+cr[ind];
                    int adjCellNo = m*adjRow+adjCol;

                    if(isValid(adjRow,adjCol,m,n)){
                        if(grid[adjRow][adjCol]==1){
                                adjPresent = true;
                                ds.UnionBySize(cellNo,adjCellNo);
                        }
                    }
                }  

                if(!adjPresent){
                    ds.parent[cellNo] = cellNo;
                    ds.size[cellNo]  = 1;
                }     
            }
        }

        int max = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int[] dr = {-1,0,1,0};
                    int[] cr = {0,1,0,-1};
                    HashSet<Integer> set = new HashSet<>();
                    int size=1;
                    for(int ind=0;ind<dr.length;ind++){
                        int adjRow = i+dr[ind];
                        int adjCol = i+cr[ind];
                        int adjCellNo = m*adjRow+adjCol;
                            if(isValid(adjRow,adjCol,m,n)){
                                int up = ds.findUParent(adjCellNo);
                                if(grid[adjRow][adjCol]==1 && !set.contains(up)){
                                    size+=ds.size[up];
                                    set.add(up);
                                }
                            }                        
                    }
                    max=Math.max(size,max);
                }
            }
        }

        return max;
    }

    public boolean isValid(int i, int j, int m, int n){
        if(i>=0 && i<m && j>=0 && j<n)
            return true;
        return false;
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