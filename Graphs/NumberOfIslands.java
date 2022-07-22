package Graphs;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    dfs(i,j,grid,visited);
                    count++;
                }
            }
        return count;
    }
    
    public boolean isLand(char[][] grid, int row,int col,int[][] visited){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length
          && grid[row][col]=='1' && visited[row][col]==0)
            return true;
        return false;
    }
    
    public void dfs(int row,int col,char[][] grid,int[][] visited){
        visited[row][col]=1;
        
        //up
        if(isLand(grid,row-1,col,visited))
            dfs(row-1,col,grid,visited);
        
        //down
        if(isLand(grid,row+1,col,visited))
            dfs(row+1,col,grid,visited);
        
        //left
        if(isLand(grid,row,col-1,visited))
            dfs(row,col-1,grid,visited);
        
        //right
        if(isLand(grid,row,col+1,visited))
            dfs(row,col+1,grid,visited);
    }
}
