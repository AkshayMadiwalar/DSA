package Graphs;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int count = 0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0 && visited[i][j] == 0){
                    boolean[] boundary = new boolean[1];
                    dfs(grid,i,j,visited,boundary);
                    if(!boundary[0])
                        count++;
                }
            }
        return count;
    }
    
    public void dfs(int[][] grid, int i, int j, int[][] visited,boolean[] boundary){
        visited[i][j]=1;
        
      
        
        if(i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1)
            boundary[0] = true;
        
        //up
        if(i>0 && grid[i-1][j]==0 && visited[i-1][j]==0)
            dfs(grid,i-1,j,visited,boundary);
        
                //up
        if(j<grid[0].length-1 && grid[i][j+1]==0 && visited[i][j+1]==0)
            dfs(grid,i,j+1,visited,boundary);
        
                //up
        if(i<grid.length-1 && grid[i+1][j]==0 && visited[i+1][j]==0)
            dfs(grid,i+1,j,visited,boundary);
        
                //up
        if(j>0 && grid[i][j-1]==0 && visited[i][j-1]==0)
            dfs(grid,i,j-1,visited,boundary);
        
   
    }
}
