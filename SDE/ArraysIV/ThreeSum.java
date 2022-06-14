public class ThreeSum {


    //3Sum, target = 0
    public List<List<Integer>> threeSum(int[] nums) {
       
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            int target2 = -1 * nums[i];
            
            int start = i+1;
            int end = nums.length - 1;
            
            while(start<end){
                if(nums[start]+nums[end] < target2) start++;
                else if(nums[start]+nums[end] > target2) end--;
                else{
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[start]);
                    res.add(nums[end]);
                    ans.add(res);
                    
                    while(start<end && nums[start]==res.get(1)) start++;
                    while(start<end && nums[end]==res.get(2)) end--;
                }
            }
            while(i+1<nums.length && nums[i+1]==nums[i])    i++;
        }
        
        return ans;
    }
}
