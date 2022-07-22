package DP;


import java.util.Arrays;

public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-2);
        }
        int cherries = stoe(0,0,grid,dp);  
        //return cherries;
       return cherries < 0  ?  0 :  cherries;
    }
    
    public int stoe(int i,int j,int[][] grid,int[][] dp){
        
        if(i>=grid.length || j>= grid[0].length)
            return (int)(-1)*(int)Math.pow(10,9);
        
        if(i==grid.length-1 && j==grid[0].length-1)
            return etos(i,j,grid,dp);
        
        if(grid[i][j]==-1)
            return (-1)*(int)Math.pow(10,9);
        
         if(dp[i][j]!=-2)
             return dp[i][j];
        
        int cherry =  grid[i][j];
        
        grid[i][j]=0;
        int down = cherry;
        int right = cherry;

        down+=stoe(i+1,j,grid,dp);
        right+=stoe(i,j+1,grid,dp);
        
        grid[i][j]=cherry;
     
        dp[i][j] = Math.max(down,right);
        return dp[i][j];
    }
    
    public int etos(int i, int j,int[][] grid,int[][] dp){
        if(i<0 || j<0)
            return (int)(-1)*(int)Math.pow(10,9);
        
        if(i==0 && j==0)
            return grid[i][j];
        
        if(grid[i][j]==-1)
            return (-1)*(int)Math.pow(10,9);
        
         if(dp[i][j]!=-2)
             return dp[i][j];
        
        int cherry =  grid[i][j];
        
        grid[i][j]=0;
        int up = cherry;
        int left = cherry;

        up+=etos(i-1,j,grid,dp);
        left+=etos(i,j-1,grid,dp);
        
        grid[i][j]=cherry;
     
        dp[i][j] = Math.max(up,left);
        return dp[i][j];
    }
}
