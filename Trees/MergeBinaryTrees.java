package Trees;

public class MergeBinaryTrees {
    // public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    //     return merge(root1,root2);
    // }
    
    // public TreeNode merge(TreeNode node1,TreeNode node2){
    //     if(node1==null && node2==null)
    //         return node1;
    //     int s = 0;
    //     if(node1!=null) s+=node1.val;
    //     if(node2!=null) s+=node2.val;
    //     TreeNode root = new TreeNode(s);
        
    //     if(node1 == null){
    //         root.left = merge(node1,node2.left);
    //         root.right = merge(node1,node2.right);
    //     }
    //     else if(node2 == null){
    //         root.left = merge(node1.left,node2);
    //         root.right = merge(node1.right,node2);
    //     }else{
    //         root.left = merge(node1.left,node2.left);
    //         root.right = merge(node1.right,node2.right);
    //     }
        
    //     return root;
    // }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }

    public TreeNode merge(TreeNode node1, TreeNode node2){
        if(node1!=null && node2!=null){
            node1.val+=node2.val;
            node1.left=merge(node1.left,node2.left);
            node1.right=merge(node1.right,node2.right);
        }
        else{
            node1 = node1==null ? node2 : node1;
        }
        return node1;
    }
}
