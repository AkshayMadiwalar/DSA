package Trees.BST;

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
}

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)  return root;
        if(root.val==key)
            return delete(root);
        TreeNode dummy = root;
        while(root!=null){
            if(root.val > key){
                if(root.left!=null && root.left.val==key){
                    root.left=delete(root.left);
                    break;
                }
                else
                    root=root.left;
            }
            else{
                if(root.right!=null && root.right.val == key){
                    root.right = delete(root.right);
                    break;
                }
                else
                    root=root.right;
            }
        }
        return dummy;
    }
    
    public TreeNode delete(TreeNode node){
        if(node.left==null) return node.right;
        else if(node.right==null) return node.left;
        else{
            TreeNode rightChild = node.right;
            TreeNode leftChild = findLastRight(node.left);
            leftChild.right=rightChild;
            return node.left;
        }
    }
    
    public TreeNode findLastRight(TreeNode node){
        if(node.right==null)    return node;
        return findLastRight(node.right);
    }
}
