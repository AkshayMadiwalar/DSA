package Trees;

public class IsSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return root==subRoot;
        if(root.val==subRoot.val)
            if(isSame(root,subRoot))
                return true;
        if(isSubtree(root.left,subRoot))
            return true;
        if(isSubtree(root.right,subRoot))
            return true;
        return false;
    }
    
    public boolean isSame(TreeNode a,TreeNode b){
        if(a==null || b==null)
            return a==b;
        return a.val==b.val && isSame(a.left,b.left) && isSame(a.right,b.right);
    }
}
