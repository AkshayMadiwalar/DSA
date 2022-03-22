package Trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    

    //Recursive soltion O(h)clea
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(lh>rh)
            return lh+1;
        return rh+1;
    }

    //Level order solution O(n)
    public int heightIterative(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int height = 1;

        while(queue.size()>0){
            int size = queue.size();
            height++;
            while(size>0){
                TreeNode node = queue.peek();
                queue.poll();

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);  
            }
        }
        return height;
    }
    
    public int maxDepth(TreeNode root) {
        return height(root);
    }
}