class Solution {
    int sum=0;
    public int maxDotProduct(int[] nums1, int[] nums2) {
         int[][] dp = new int[nums1.length][nums2.length];
         return mp(0,0,nums1,nums2,dp);
    }

    public int mp(int i, int j, int[] nums1, int[] nums2, int[][] dp){

        if(i == nums1.length || j == nums2.length){
            return -1001;
        }

        if(dp[i][j]!=0)
            return dp[i][j];

   
        int take = nums1[i]*nums2[j] + Math.max(mp(i+1,j+1,nums1,nums2,dp),0);
        int m1 = mp(i+1,j,nums1,nums2,dp);
        int m2 = mp(i,j+1,nums1,nums2,dp);

        dp[i][j] = Math.max(Math.max(m1,m2),take);

        return dp[i][j];
    }
}