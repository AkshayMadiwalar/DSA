package Trees.BST;

public class KthLargestElement {
    int c=0;
    int largest=0;
    public int kthLargest(Node root,int K)
    {
        //Your code here
        c=K;
        rio(root);
        return largest;
    }
    public void rio(Node root){
        if(root==null)
            return;
        rio(root.right);
        c--;
        if(c==0){
            largest=root.data;
            return;
        }
        rio(root.left);
    }
}
