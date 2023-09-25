package Trees;

public class ConstructBSTfromLevelOrderTraversal {
    public Node constructBST(int[] arr)
    {
        //Write your code here
        
        Node root = null;
        
        for(int i=0;i<arr.length;i++){
            root = constructBst(root,arr[i]);
        }
        
        return root;
    }
    
    public Node constructBst(Node root, int data){
        if(root==null){
            root = new Node(data);
            return root;
        }
        
        if(data<=root.data){
            root.left = constructBst(root.left,data);
        }
        else{
            root.right = constructBst(root.right,data);
        }

        return root;
    }
}
