public class MajorityElement_Nby3 {

    //Moore's algorithm 
    // two variables, c1 c2 & n1 n2
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int n1 = -1;
        int n2 = -1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == n1) c1++;
            else if(nums[i] == n2) c2++;
            else if(c1==0){
                n1 = nums[i];
                c1++;
            }
            else if(c2==0){
                n2 = nums[i];
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        c1=0;
        c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == n1){
                c1++;
            }
            else if(nums[i] == n2){
                c2++;
            }
        }
        
        if(c1 > (nums.length/3)) ans.add(n1);
        if(c2 > (nums.length/3)) ans.add(n2);
        
        return ans;
    }
}
