package Trees.BST;

public class ConvertSortedArrayToBST {
    public Node constructBST(int[] nums,int low,int high){
        if(low>high)
            return null;
        int mid = (low+high)/2;
        Node root = new Node(nums[mid]);
        root.left = constructBST(nums,low,mid-1);
        root.right = constructBST(nums,mid+1,high);
        return root;
    }
}

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}