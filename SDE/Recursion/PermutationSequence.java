package SDE.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    
    //n=4
    //nums=1,2,3,4
    //k=17 => 17th permutation ?
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            nums.add(i);
        }
        nums.add(n);
        k=k-1;
        
        String ans = "";
        while(true){
            int ele = nums.get(k/fact);
            ans=ans+String.valueOf(ele);
            nums.remove(nums.indexOf(ele));
            if(nums.size()==0)
                break;
            k=k%fact;
            fact=fact/nums.size();
        }
        
        return ans;
    }
}
