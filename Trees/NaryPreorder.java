package Trees;

import java.util.*;

public class NaryPreorder {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        preOrd(root,ans);
        return ans;
    }
    
    public void preOrd(Node root,List<Integer> ans){
        if(root==null)
            return;
        ans.add(root.val);
        for(int i=0;i<root.children.size();i++){
            preOrd(root.children.get(i),ans);
        }
    }
}
