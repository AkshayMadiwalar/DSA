package Trees;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    
    public void io(TreeNode root){
        if(root ==null){
            return;
        }
        
        list.add(root.val); 
        io(root.left);
        io(root.right);
        
        if(root.left == null && root.right ==null){
            //reached leaf
            String path = "";
            for(int i=0;i<list.size();i++){
                if(i==list.size()-1){
                    path = path + list.get(i);
                }else{
                    path = path + list.get(i) + "->";
                }
            }
            ans.add(path);
        }
        list.remove(list.size()-1);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        io(root);
        return ans;
    }
}