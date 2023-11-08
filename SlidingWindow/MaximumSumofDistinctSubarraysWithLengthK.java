class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;

        long sum = 0;
        long max = 0;

        while(end<nums.length){
            sum+=(long)nums[end];

         map.put(nums[end],map.getOrDefault(nums[end],0)+1);

            if(end-start+1 == k){
                if(map.size() == k)
                //distinct elements
                max=Math.max(max, sum);
            }
            else if(end-start+1>k){
                while(end-start+1>k){
                    sum-=(long)nums[start];
                    if(map.get(nums[start]) ==1)
                        map.remove(nums[start]);
                    else
                        map.put(nums[start],map.get(nums[start])-1);
                    start++;
                }
                
                if(end-start+1 == map.size() && end-start+1==k){
                    max=Math.max(max, sum);
                }
            }
            end++;
        }

        return max;
    }
}