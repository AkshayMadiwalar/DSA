package DP;

public class HouseRobberII {
    public int sum(int[] nums){
        int prev2=0;
        int prev=nums[0];
        for(int i=1;i<nums.length;i++){
            int p=nums[i]+prev2;
            int np=prev;
            int cur=Math.max(p,np);
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int[] temp1=new int[nums.length-1];
        int[] temp2=new int[nums.length-1];
        int a = 0;
        int b= 0;
        if(nums.length==1)  return nums[0];
        
        for(int i=0;i<nums.length;i++){
            if(i!=0){
                temp1[a]=nums[i];
                a++;
            }
            if(i!=nums.length-1){
                temp2[b]=nums[i];
                b++;
            }
        }
        return Math.max(sum(temp1),sum(temp2));
    }
}
