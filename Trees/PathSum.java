package Trees;

class Solution {
    public boolean hasSum(TreeNode root, int sum){
        
        int subsum = sum - root.val;
        boolean ans = false;
        if(subsum == 0 && root.left==null && root.right==null){
            return true;
        }
        
        if(root.left!=null){
            ans = ans || hasSum(root.left,subsum);
        }
        
        if(root.right!=null){
            ans = ans || hasSum(root.right,subsum);
        }
        
        return ans;
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        return hasSum(root,targetSum);
    }
}