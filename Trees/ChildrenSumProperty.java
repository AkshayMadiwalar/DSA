package Trees;

public class ChildrenSumProperty {
    
    public static int issum(Node root){
            
        if(root==null){
            return 1;
        }
        
        if(root.left == null && root.right ==null){
            return 1;
        }
        
        int l =  root.left == null ? 0 : root.left.data;
        int r = root.right == null ? 0 : root.right.data;
        
        if(l+r==root.data &&
            issum(root.left)==1 && issum(root.right)==1
        )
            return 1;
        return 0;
    }


    public static int isSumProperty(Node root)
    {
        int ans = issum(root);
        return ans;
    }
}
