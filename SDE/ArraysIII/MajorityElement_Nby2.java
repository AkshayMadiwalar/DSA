public class MajorityElement_Nby2 {

    //Moore's voting algorithm

    // [2 2 1 1 1 2 2]
    // cancels out euals number of elements
    // 2 2 1 1              1 2 2
    // count becomes 0      here majority is 2

    // Time: O(N) time and O(1) space
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int ele = 0;
        
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                ele = nums[i];
            }
            
            if(ele == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return ele;
    }
}
