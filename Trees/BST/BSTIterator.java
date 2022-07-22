package Trees.BST;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        push(root);
    }
    
    public void push(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        if(node.right!=null)
            push(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.empty();
    }
}
