package Trees;

public class BinaryTreeToString {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }
    
    public void preorder(TreeNode root,StringBuilder res){
        if(root==null){
            return;
        }
        res.append(root.val);
        if(root.left!=null || root.right!=null){
            res.append("(");
            preorder(root.left,res);
            res.append(")");
            if(root.right!=null){
                res.append("(");
                preorder(root.right,res);
                res.append(")");
            }
        }
    }
}
