package Trees;

public class FlattenBinaryTreeToLinkedList {
    
    TreeNode prev=null;

    //Time O(N) Space O(N)
    public void flatten(TreeNode root) {
        if(root==null) return;

        flatten(root.right);
        flatten(root.left);

        root.right=prev;
        root.left=null;
        prev=root;
    }

}
