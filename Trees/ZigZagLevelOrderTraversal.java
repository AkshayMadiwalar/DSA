package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       Stack<TreeNode> s1 = new Stack<>();
       Stack<TreeNode> s2 = new Stack<>();
        
       s1.push(root);
        
        List<List<Integer>> ans = new LinkedList<>();
        
        if(root==null){
            return ans;
        }
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            
            List<Integer> subList = new LinkedList<>();
            while(!s1.isEmpty()){
                TreeNode node = s1.peek();
                s1.pop();
                subList.add(node.val);
                if(node.left!=null){
                    s2.push(node.left);
                }
                if(node.right!=null){
                    s2.push(node.right);
                }
            }
            if(subList.size()>0){
                  ans.add(subList);
            }
          
            
            List<Integer> subList2 = new LinkedList<>();
            while(!s2.isEmpty()){
                TreeNode node = s2.peek();
                s2.pop();
                subList2.add(node.val);
                if(node.right!=null){
                    s1.push(node.right);
                }
                if(node.left!=null){
                    s1.push(node.left);
                }
            }
            if(subList2.size()>0){
                       ans.add(subList2);          
            }
     
        }
        return ans;
    }
}