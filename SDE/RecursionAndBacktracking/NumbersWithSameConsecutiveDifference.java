package SDE.RecursionAndBacktracking;

import java.util.*;

public class NumbersWithSameConsecutiveDifference {
    List<Integer> ans  = new ArrayList<>();
    
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ds = new ArrayList<>();
        func(n,k,0,ds);
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
    
    public void func(int n, int k, int ind,List<Integer> ds){
        
        if(ind == n){
            int num = 0;
            for(int i=0;i<ds.size();i++){
                num=10*num+ds.get(i);
            }
            ans.add(num);
            return;
        }
        
        for(int i=0;i<=9;i++){
            if(ind==0){
                if(i==0)
                    continue;
                ds.add(i);
                func(n,k,ind+1,ds);
                ds.remove(ds.size()-1);
            }
            else{
                if( Math.abs(ds.get(ind-1)-i)==k){
                    ds.add(i);
                    func(n,k,ind+1,ds);
                    ds.remove(ds.size()-1);
                }
            }
        }
    }
}
