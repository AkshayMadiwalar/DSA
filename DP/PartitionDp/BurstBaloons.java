class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        arr[0]=1;
        for(int i=0;i<nums.length;i++){
            arr[i+1]=nums[i];
        }
        arr[arr.length-1]=1;
        return burst(arr, 1, nums.length);
    }

    public int burst(int[]  arr, int i, int j){
        if(i>j)
            return 0;

        int max = Integer.MIN_VALUE;

        for(int ind=i;ind<=j;ind++){
            int ans = arr[i-1]*arr[ind]*arr[j+1] + burst(arr, i, ind-1) + burst(arr,ind+1,j);
            max=Math.max(ans,max);
        }

        return max;
    }
}