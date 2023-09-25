package Trees.BST;

public class InorderSuccessor {
    public Node inorderSuccessor(Node root,Node x)
    {
     //add code here.
     Node successor = null;
     while(root!=null){
         if(root.data<=x.data){
             root=root.right;
         }else{
             successor=root;
             root=root.left;
         }
     }
     return successor;
    }
}