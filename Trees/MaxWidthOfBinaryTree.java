package Trees;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}


class Solution {
    

    //Using 0-indexing for each node, and do a level order traversal
    //parent:0  lChild: 2i+1    rChild: 2i+2
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        
        int width   = 0;
        
        while(!queue.isEmpty()){
            int size =queue.size();
            int min = queue.peek().num;
            int first = 0;
            int last = 0;
            int i = 1;
            while(i<=size){
                Pair pair = queue.poll();
                if(i == size)    last = pair.num;
                if(i == 1) first = pair.num;        
                if(pair.node.left!=null){
                    queue.add(new Pair(pair.node.left,2*(pair.num-min)+1));
                }
                if(pair.node.right!=null){
                    queue.add(new Pair(pair.node.right,2*(pair.num-min)+2));
                }
                i++;
            }
            if(width < (last-first+1)){
                width = last-first + 1;
            }
        }
        return width;
    }
}