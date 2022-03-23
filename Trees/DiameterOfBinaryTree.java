package Trees;

class Solution {
    
    public int max = Integer.MIN_VALUE;

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(this.max < (lh+rh)){
                this.max = lh+rh;
        }
        
        if(lh>rh){
            return lh+1;
        }
        return rh+1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root.left==null && root.right==null){
            return 0;
        }
        height(root);
        return this.max;
    }
}