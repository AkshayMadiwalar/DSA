public class Permutations {

    // ---------------Approach 1--------------------- 
    //Time: O(n!*n)
    //space: O(n)+O(n) extra datastructure and hashmap 
    public void perm(int[] nums, List<List<Integer>> ans, List<Integer> ds, HashMap<Integer, Integer> map) {

        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
                ds.add(nums[i]);
                perm(nums, ans, ds, map);
                ds.remove(ds.size() - 1);
                map.remove(i);
            }
        }
    }


    // -------------------Approach2------------------------- swaping
    // No extra space, Time O(N!*n) 
    public void perm2(int index, int[] nums, List<List<Integer>> ans){
        
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=index;i<nums.length;i++){
           swap(nums,i,index);
            perm2(index+1,nums,ans);
            swap(nums,i,index);
        }
    }
    

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        perm(nums, ans, new ArrayList<>(), map);
        return ans;
    }
}
