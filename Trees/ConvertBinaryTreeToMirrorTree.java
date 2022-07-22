package Trees;

public class ConvertBinaryTreeToMirrorTree {
     // Function to convert a binary tree into its mirror tree.
     void mirror(Node node) {
        // Your code here
        cm(node);
    }
    
    void cm(Node n){
        
        if(n==null)
            return;
    
        Node temp = n.left;
        n.left=n.right;
        n.right=temp;
        
        cm(n.left);
        cm(n.right);
    }
}
