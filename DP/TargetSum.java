public class TargetSum {
    
    //Same as Count of Subset sums with given differnce

    //number of ways to get the target sum 


    //------------------------------------------------------------
    // int dp[n+1][sum+1];
        
    // for(int i = 0; i<n+1; i++) dp[i][0] = 1;
    // for(int i = 1; i<sum+1; i++) dp[0][i] = 0;
    
    // for(int i = 1; i<n+1; i++){
    //     for(int j = 0; j<sum+1; j++){
    //         if(nums[i-1] <= j){
    //             dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
    //         }
    //         else{
    //             dp[i][j] = dp[i-1][j];
    //         }
    //     }
    // }
    // return dp[n][sum];
}
