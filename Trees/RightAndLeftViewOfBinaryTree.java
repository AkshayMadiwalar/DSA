package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    
    Queue<TreeNode> q = new LinkedList<>();
    
    
    List<Integer> list = new LinkedList<>();


    public void recursive(TreeNode root,int level){
        if(root == null){
            return;
        }

        if(level == list.size()){
            list.add(root.val);
        }

        recursive(root.right, level+1);
        recursive(root.left, level+1);

        // For left view 
        recursive(root.left, level+1);
        recursive(root.right, level+1);
    }
    

    //iterative method
    public void lot(TreeNode root){
        q.add(root);
        
        while(q.size()!=0){
            int size = q.size();
            while(size>0){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                if(size-1 == 0){
                    list.add(node.val);
                }
                size--;
            }
        }
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return list;
        }
        lot(root);
        

        //recursive approac
        //recursive(root, 0);
        return list;
    }
}