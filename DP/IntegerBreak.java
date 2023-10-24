  public int integerBreak(int n) {
        int[][] dp =new int[n+1][n+1];
        return ib(n-1,n, dp);
    }

    public int ib(int ind, int n, int[][] dp){
        
        if(ind == 0 || n == 0)
            return 1;

        if(ind>n)
            return ib(ind-1,n,dp);

        if(dp[ind][n]!=0){
            return dp[ind][n];
        }
        
        
        dp[ind][n] = Math.max(
            ib(ind-1,n,dp),
            ind*ib(ind,n-ind,dp)
            );

        return dp[ind][n];
    }