package SDE.ArraysIII;

public class UniqueGridPaths {


    //Recursive DP Solution (memoization)
    // O(m*n)
    // O(m*n) space
    public int countPaths(int i, int j, int m, int n,int[][] dp){
        if(i == (m-1) && j == (n-1))    return 1;
        if(i>=m || j>= n)   return 0;
        if(dp[i][j]!=-1){
            return dp[i][j]; 
        }
        dp[i][j] = countPaths(i+1,j,m,n,dp)+ countPaths(i,j+1,m,n,dp);
        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return countPaths(0,0,m,n,dp);


        //Optial Approach
        // int N = m+n-2;
        // int r = m-1;
        // return (int) ( fact(N) / (fact(N-r)*fact(r)));
    }


}
