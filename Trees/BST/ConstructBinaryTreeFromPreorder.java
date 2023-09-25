package Trees.BST;

public class ConstructBinaryTreeFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder,new int[]{0},Integer.MAX_VALUE);
    }
    
    public TreeNode bst(int[] preorder,int[] ind,int ub){
        
         if(ind[0]==preorder.length) return null;
        
        if(preorder[ind[0]]>ub) return null;
        
        TreeNode root = new TreeNode(preorder[ind[0]]);
        ind[0]++;
        root.left=bst(preorder,ind,root.val);
        
        root.right=bst(preorder,ind,ub);
        return root;
    }
}
