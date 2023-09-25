package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size()>0){
            int size = queue.size();
            boolean xpresent = false;
            boolean ypresent = false;

            while(size>0){
                TreeNode node = queue.poll();
                if(node.val == x)
                    xpresent = true;
                if(node.val == y)
                    ypresent = true;
                if(node.left!=null && node.right!=null)
                    if((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x))
                        return false;
                
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);

                size--;
            }    

            if(xpresent && ypresent )
                return true;   
        }

        return false;
    }
}
