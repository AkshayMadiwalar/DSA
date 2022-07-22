package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointers {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        
        if(root == null){
            return root;
        }
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                Node node  = q.poll();
                Node nodenext = q.peek();
                
                if(size-1 == 0){
                    node.next = null;
                }else{
                    node.next = nodenext;
                }
                
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                
                size--;
            }
        }
        
        return root;
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
