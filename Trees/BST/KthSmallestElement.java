package Trees.BST;

public class KthSmallestElement {
    
    int c = 0;
    int f = 0;
    public void io(TreeNode root){
        if(root==null){
            return;
        }
        io(root.left);
        c=c-1;
        if(c==0){
            f=  root.val;
        }
        io(root.right);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        c= k;
        io(root);
        return f;
    }
}
