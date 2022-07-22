package Trees.BST;

import java.util.Stack;

class BSTIterator{
    
    private Stack<TreeNode> stack = new Stack<>();
    
    BSTIterator(TreeNode root, Boolean reverse){
        push(root,reverse);
    }
    
    public void push(TreeNode root, Boolean reverse){
        while(root!=null){
            stack.push(root);
            if(reverse)
                root=root.right;
            else   
                root=root.left;
        }
    }
    
    public int next(){
        TreeNode node = stack.pop();
        if(node.right!=null)
            push(node.right,false);
        return node.val;
    }
    
    public int before(){
        TreeNode node = stack.pop();
        if(node.left!=null)
            push(node.left,true);
        return node.val;
    }
}



public class TwoSuminBST {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root,false);
        BSTIterator right = new BSTIterator(root,true);
        
        int i=left.next();
        int j=right.before();
        
        while(i<j){
            if(i+j==k)  return true;
            else if(i+j < k){
                i=left.next();
            }else{
                j=right.before();
            }
        }
        return false;
    }
}
