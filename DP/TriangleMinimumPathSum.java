package DP;
import java.util.*;

public class TriangleMinimumPathSum {
    
      
    //Recursion-----
    public int minsum(List<List<Integer>> triangle, int i, int j){
        if(i==triangle.size()-1)
            return triangle.get(i).get(j);
        
        int down=triangle.get(i).get(j)+minsum(triangle,i+1,j);
        int diagonal=triangle.get(i).get(j)+minsum(triangle,i+1,j+1);
        return Math.min(down,diagonal);
    }
    
    //Memoization-----
    public int minsumMemo(List<List<Integer>> triangle, int i, int j,int[][] dp){
        if(i==triangle.size()-1)
            return triangle.get(i).get(j);
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int down=triangle.get(i).get(j)+minsum(triangle,i+1,j);
        int diagonal=triangle.get(i).get(j)+minsum(triangle,i+1,j+1);
        
        dp[i][j] = Math.min(down,diagonal);
        return dp[i][j];
    }
    

    // Tabulation ---- bottom up 
    public int minsumTab(List<List<Integer>> triangle,int[][] dp){
        
        int lastrow =   triangle.size()-1;
        
        for(int j=0;j<triangle.get(lastrow).size();j++)
            dp[lastrow][j] = triangle.get(lastrow).get(j);
        
        for(int i=lastrow-1;i>=0;i--)
            for(int j=i;j>=0;j--){
                    int down=triangle.get(i).get(j)+dp[i+1][j];
                    int diag = triangle.get(i).get(j)+dp[i+1][j+1];
                    dp[i][j]=Math.min(down,diag);           
            }
        return dp[0][0];
                
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        int[][] dp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return minsumTab(triangle,dp);
        
    }
}
