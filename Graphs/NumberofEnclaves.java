class Solution {
    public int numEnclaves(int[][] grid) {
        
        int[][] visited = new int[grid.length][grid[0].length];

        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i] == 1 && visited[0][i] == 0){
                dfs(grid, 0,i, visited);
            }
            int n = grid.length;
            if(grid[n-1][i] == 1 && visited[n-1][i] == 0){
                dfs(grid,n-1,i, visited);
            }
        }

        for(int i=0;i<grid.length;i++){
            if(grid[i][0] == 1 && visited[i][0] == 0){
                dfs(grid, i,0, visited);
            }
            int n = grid[0].length;
            if(grid[i][n-1] == 1 && visited[i][n-1] == 0){
                dfs(grid,i,n-1, visited);
            }
        }

        int c= 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    c++;
            }
        }

        return c;
    }

    public void dfs(int [][] grid, int i, int j, int[][] visited){
        visited[i][j] = 1;

        if(grid[i][j]==1)
            grid[i][j]=0;
        else
            return;

        //up
        if(i>0 && grid[i-1][j]==1 && visited[i-1][j]==0)
            dfs(grid,i-1,j,visited);
        
        //right
        if(j<grid[0].length-1 && grid[i][j+1]==1 && visited[i][j+1] == 0)
            dfs(grid,i,j+1,visited);

        //bottom
        if(i<grid.length-1 && grid[i+1][j]==1 && visited[i+1][j]==0)
            dfs(grid,i+1,j,visited);
        
        //left
        if(j>0 && grid[i][j-1]==1 && visited[i][j-1] == 0)
            dfs(grid,i,j-1,visited);
    }
}