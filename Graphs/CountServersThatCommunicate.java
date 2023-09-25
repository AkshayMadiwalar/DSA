package Graphs;

public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
         
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] visited = new int[m][n];
        
        int ans = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    int[] c = new int[]{0};
                    count(i,j,m,n,grid,visited,c);
                    if(c[0]>0)
                        c[0]++;
                    ans+=c[0];
                }
            }
        }
        
        return ans;
    }
    
    
    public void count(int i,int j,int m,int n,int[][] grid,int[][] visited,int[] c){
        
        visited[i][j]=1;
        
        for(int x=0;x<n;x++){
            if(grid[i][x]==1 && visited[i][x]==0){
                c[0]++;
                count(i,x,m,n,grid,visited,c);
            }
        }
        
        for(int x=0;x<m;x++){
            if(grid[x][j]==1 && visited[x][j]==0){
                c[0]++;
                count(x,j,m,n,grid,visited,c);
            }
        }
    }
}
