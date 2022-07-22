package Graphs;

public class MaxAreaofIsLand {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    int[] area = new int[1];
                    area[0]=1;
                    int[] a = isLand(i,j,grid,visited,area);
                    max = Math.max(max,a[0]);
                }
            }
        }
        return max;
    }
    
    public int[] isLand(int i,int j,int[][] grid,int[][] visited,int[] area){
        
        visited[i][j]=1;
        
        //up
        if(i-1>=0 && grid[i-1][j]==1 && visited[i-1][j]==0){
            area[0]++;
            isLand(i-1,j,grid,visited,area);
        }
        
        //right
        if(j+1<grid[0].length && grid[i][j+1]==1 && visited[i][j+1]==0){
            area[0]++;
            isLand(i,j+1,grid,visited,area);
        }
        
        //down
        if(i+1<grid.length && grid[i+1][j]==1 && visited[i+1][j]==0){
            area[0]++;
            isLand(i+1,j,grid,visited,area);
        }
        
        //left
        if(j-1>=0 && grid[i][j-1]==1 && visited[i][j-1]==0){
            area[0]++;
            isLand(i,j-1,grid,visited,area);
        }
        
        return area;
    }
}
