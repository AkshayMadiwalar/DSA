package Trees.BST;

public class LCAofBST {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null)   return root;
        
        TreeNode cur = root;
        
       
        if(cur.val<p.val && cur.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        else if(cur.val>p.val && cur.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        
        return cur;
    }
}
