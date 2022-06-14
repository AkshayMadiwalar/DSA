public class FourSum {
    

    //O(n3)
    //space O(1)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                
                int target2 = target - nums[j] - nums[i];
                
                int start = j+1;
                int end = nums.length-1;
                
                while(start<end){
                    if(nums[start]+nums[end]<target2)
                        start++;
                    else if(nums[start]+nums[end]>target2)
                        end--;
                    else{
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[start]);
                        res.add(nums[end]);
                        ans.add(res);
                        
                        while(start<end && nums[start]==res.get(2)){
                            start++;
                        }
                        while(start<end && nums[end]==res.get(3)){
                            end--;
                        }
                    }              
                }
                
                
                while(j+1<nums.length && nums[j+1]==nums[j]) j=j+1;
            }
            while(i+1<nums.length && nums[i+1]==nums[i]) i=i+1;
        }
        
        return ans;
    }
}
