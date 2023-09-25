package Trees;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        
        return prune(root)?root:null;
       // return root;
    }
    
    public boolean prune(TreeNode root){
        
        if(root==null){
            return false;
        }
        
        boolean leftHas = prune(root.left);
        boolean rightHas = prune(root.right);
        
        if(!leftHas) 
            root.left=null;
        if(!rightHas)
            root.right=null;
        
        return leftHas || rightHas || root.val == 1;
    }
}
