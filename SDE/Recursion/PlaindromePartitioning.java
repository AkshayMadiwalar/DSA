package SDE.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PlaindromePartitioning {
    public void pp(int ind,String s,List<String> path, List<List<String>> ans){
        
        if(ind==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                path.add(s.substring(ind,i+1));
                pp(i+1,s,path,ans);
                path.remove(path.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans =new ArrayList<>();
        List<String> path =new ArrayList<>();
        pp(0,s,path,ans);
        return ans;
    }
}
