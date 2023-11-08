class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];

        if(grid[0][0]!=0 || grid[grid.length-1][grid[0].length-1] !=0)
            return -1;
        for(int[] arr:dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dist[0][0]=1;
        Queue<Pair> pq = new LinkedList<>();

        pq.add(new Pair(0,0,1));

        while(pq.size()>0){
            Pair pair = pq.poll();
            int x = pair.x;
            int y=pair.y;
            int cur_dist = pair.dist;

            if(x == grid.length-1 && y == grid[0].length-1){
                return cur_dist;
            }
            

            int[] dr = {-1,0,1,-1,-1,0,1,1};
            int[] cr= {-1,-1,-1,0,1,1,1,0};

            for(int i=0;i<dr.length;i++){
                int r=dr[i];
                int c=cr[i];
                if(x+r>=0 && x+r < grid.length &&
                    y+c>=0 && y+c<grid[0].length &&
                        grid[x+r][y+c]==0 && 1+cur_dist<dist[x+r][y+c] ){
                                dist[x+r][y+c]=1+cur_dist;
                                if(x+r == grid.length-1 && y+c == grid[0].length-1){
                                    return 1+cur_dist;
                                }
                                pq.add(new Pair(x+r,y+c,1+cur_dist));
                        }
            }
        
        }
        return -1;
        
    }
}

class Pair{
    int x;
    int y;
    int dist;
    Pair(int x, int y, int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}