package Trees;

class Solution {
    
    public int max = Integer.MIN_VALUE;
    
    public int sum(TreeNode root){
        if(root ==null){
            return 0;
        }
        
        //ignore negative values, so check for greater than 0
        int ls = Math.max(0,sum(root.left));
        int rs = Math.max(0,sum(root.right));
        
        if(max < (root.val + ls +rs)){
            max = root.val + ls +rs;
        }
        
        return root.val + Math.max(ls,rs);
    }
    
    public int maxPathSum(TreeNode root) {
        sum(root);
        return max;
    }
}