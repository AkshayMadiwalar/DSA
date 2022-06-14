
public class FindDuplicate {

    // time: O(N) space: o(1)
    // slow and fast pointers
    // slow and fast collides when slow travels a, fast travels 2a
    // second collision move each pointer by 1 step, collision gices duplicate  number 
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        
        fast = nums[0];
        
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
    }

    //other approach: Hash method: extra space
}
