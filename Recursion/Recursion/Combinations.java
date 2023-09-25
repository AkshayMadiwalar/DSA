package Recursion;

import java.util.*;

public class Combinations {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        comb(1,k,new ArrayList<>(),n);
        return ans;
    }
    
    public void comb(int ind,int k,List<Integer> ds,int n){
        
        if(ds.size()>k || ind>n+1)
            return;
        
        if(ds.size()==k){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        //pick
        ds.add(ind);
        comb(ind+1,k,ds,n);
        ds.remove(ds.size()-1);
        
        //not pick
        comb(ind+1,k,ds,n);
    
    }
}
