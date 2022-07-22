package Trees.BST;

public class InorderPredecessor {
    public Node inOrderPredecessor(Node root,Node x)
    {
     //add code here.
     Node pred = null;
     while(root!=null){
         if(root.data>=x.data){
             root=root.left;
         }else{
            pred=root;
            root=root.right;
         }
     }
     return pred;
    }
}
