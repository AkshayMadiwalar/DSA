package SDE.ArraysIV;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {


    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        int streak = 0;
        
        if(nums.length==0)  return 0;
        
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                if(set.contains(nums[i]+1)){
                    int c = 1;
                    int n = nums[i];
                    while(set.contains(n+1)){
                        c++;
                        n++;
                    }
                    if(streak<c) streak =c;
                }
            }
        }

        if(streak == 0) streak = 1;
        
        return streak;
    }
}
