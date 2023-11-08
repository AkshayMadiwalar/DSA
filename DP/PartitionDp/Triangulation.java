public int minScoreTriangulation(int[] values) {
        int n=values.length-1;
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++) dp[i][j]=-1;
        }
        return solveMem(values,0,n,dp);
    }
    private int solveMem(int[] values,int i,int j,int[][] dp){
        if(i+1==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            ans=Math.min(ans,values[i]*values[j]*values[k]+solveMem(values,i,k,dp)+solveMem(values,k,j,dp));
        }
        dp[i][j]=ans;
        return dp[i][j];
    }
}