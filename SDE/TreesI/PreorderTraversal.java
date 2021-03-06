package SDE.TreesI;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        
        if(root == null){
            return list;
        }
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            stack.pop();
            list.add(node.val);
            
            if(node.right!=null){
                stack.push(node.right);
            }
            
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        
        return list;
    }
}
