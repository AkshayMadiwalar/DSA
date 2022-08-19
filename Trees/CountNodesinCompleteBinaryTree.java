package Trees;

public class CountNodesinCompleteBinaryTree {
    
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        
        int lh=lheight(root);
        int rh=rheight(root);
        
        if(lh==rh)  return (int)Math.pow(2,lh)-1;
        
        return countNodes(root.left)+1+countNodes(root.right);
    }
    
    public int lheight(TreeNode root){
        int c=0;
        while(root!=null){
            c++;
            root=root.left;
        }
        return c;
    }
    
    public int rheight(TreeNode root){
        int c=0;
        while(root!=null){
            c++;
            root=root.right;
        }
        return c;
    }
}
