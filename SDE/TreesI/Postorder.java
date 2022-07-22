package SDE.TreesI;

import java.util.LinkedList;
import java.util.List;

public class Postorder {
    List<Integer> list = new LinkedList<>();
    
    public void po(TreeNode node){
        if(node == null){
            return;
        }
        po(node.left);
        po(node.right);
        list.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        po(root);
        return list;
    }
}
