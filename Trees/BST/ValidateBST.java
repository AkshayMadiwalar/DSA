package Trees.BST;

public class ValidateBST {
    
    public boolean validate(TreeNode root,long minval,long maxval){
        if(root==null)  return true;
        if(root.val>=maxval || root.val<=minval)  return false;
        return validate(root.left,minval,root.val)
            &&
            validate(root.right,root.val,maxval);
        
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
