package Trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    
    boolean ans = true;
    
    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int lheight = height(node.left);
        int rheight = height(node.right);
        
        if(Math.abs(lheight - rheight) > 1){
            ans = false;
        }
        
        if(lheight> rheight){
            return lheight + 1;
        }
        return rheight + 1;
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return ans;
    }
}