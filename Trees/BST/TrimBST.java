package Trees.BST;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return trim(root,low,high);
    }
    
    public TreeNode trim(TreeNode root,int low,int high){
        if(root==null)
            return root;
        
        if(root.val>high){
            return trim(root.left,low,high);
        }
        if(root.val<low){
            return trim(root.right,low,high);
        }
        
        root.left=trim(root.left,low,high);
        root.right=trim(root.right,low,high);
        return root;
    }
}
