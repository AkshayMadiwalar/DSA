package DP;

public class MinimumPathSum {
    
    public int minsum(int[][] grid,int[][] dp){
        //         if(i==0 && j==0)
        //             return grid[i][j];
                
        //         if(i==0 && j!=0)
        //             return grid[i][j]+minsum(i,j-1,grid);
        //         if(j==0 && i!=0)
        //             return grid[i][j]+minsum(i-1,j,grid);
                
        //         int up=grid[i][j]+minsum(i-1,j,grid);
        //         int left=grid[i][j]+minsum(i,j-1,grid);
        //         return Math.min(up,left);
                
                for(int i=0;i<grid.length;i++){
                    for(int j=0;j<grid[0].length;j++){
                        if(i==0 && j==0)
                            dp[i][j]=grid[i][j];
                        else{
                            int up=grid[i][j];
                            int left=grid[i][j];
                            
                            if(i>0)
                                up+=dp[i-1][j]; //go up
                            else
                                up+=dp[i][j-1]; // row=0,go left only
                                
                         
                            if(j>0)
                                left+=dp[i][j-1]; // go left
                            else
                                left+=dp[i-1][j]; //col=0,go up only
                    
                            
                            dp[i][j]=Math.min(up,left);
                        }
                    }
                }
                return dp[grid.length-1][grid[0].length-1];
            }
            public int minPathSum(int[][] grid) {
                int m=grid.length;
                int n=grid[0].length;
                
                int[][] dp = new int[m][n];
                for(int i=0;i<m;i++)
                    for(int j=0;j<n;j++)
                        dp[i][j]=0;
                
                return minsum(grid,dp);
            }
}
