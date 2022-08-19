package Trees;

public class CountGoodNodes {
     
    int count = 0;
    
    public int goodNodes(TreeNode root) {
        count(root,Integer.MIN_VALUE);
        return count;
    }
    
    public void count(TreeNode root, int min){
        if(root==null)
            return;
        
        if(root.val>=min)
            count++;
        min = Math.max(min,root.val);
        count(root.left,min);
        count(root.right,min);
    }
}
