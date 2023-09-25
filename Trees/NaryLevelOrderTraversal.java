package Trees;

import java.util.*;

public class NaryLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root==null)
            return ans;
        
        queue.add(root);
        
        while(queue.size()>0){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while(size>0){
                Node node = queue.poll();
                level.add(node.val);
                List<Node> children = node.children;
                for(Node child: children){
                    queue.add(child);
                }
                size--;
            }
            ans.add(new ArrayList<>(level));
            level.clear();
        }
        
        return ans;
        
    } 
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};