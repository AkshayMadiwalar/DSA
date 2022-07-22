package DP;

import java.util.Arrays;

public class MinimumFallingSumInMatrix {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int min=(int)Math.pow(10,9);
        
        int[][] dp =new int[m][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-101);
        }
        for(int i=0;i<n;i++){
            min=Math.min(min,func(n-1,i,matrix,dp));
        }
        return min;
    }
    
    //Memoization---
    public int func(int i  int j, int[][] a, int[][] dp){
        
        if(j<0 || j>=a[0].length) return (int)Math.pow(10,9);
        
        if(i==0) return a[i][j];
        
        if(dp[i][j]!=-101)
            return dp[i][j];
        
        int up = a[i][j]+func(i-1,j,a,dp);
        int ld = a[i][j]+func(i-1,j-1,a,dp);
        int rd = a[i][j]+func(i-1,j+1,a,dp);
        
        dp[i][j] = Math.min(Math.min(up,ld),rd);
        
        return dp[i][j];
    }
    
    //Tabulation---
    public int funcTab(int[][] a, int[][] dp){
        
        
        for(int i=0;i<a[0].length;i++){
            dp[0][i]=a[0][i];
        }
        
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                int up = a[i][j]+dp[i-1][j];
                int ld  = a[i][j];
                int rd= a[i][j];
                
                if(j>1)
                    ld+=dp[i-1][j-1];
                else
                    ld+=(int)Math.pow(10,9);
                
                if(j<a[0].length-1)
                    rd+=dp[i-1][j+1];
                else
                    rd+=(int)Math.pow(10,9);
                
                dp[i][j]=Math.min(Math.min(up,ld),rd);
            }
        }
        
        return dp[a.length-1][a[0].length-1];
    }
}
