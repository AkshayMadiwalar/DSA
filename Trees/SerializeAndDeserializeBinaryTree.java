package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder ser= new StringBuilder();
        
        while(queue.size()>0){
                TreeNode node = queue.poll();
                if(node!=null){
                    ser.append(node.val+",");
                    queue.add(node.left);
                    queue.add(node.right);
                }else{
                    ser.append("#,");
                }
      
        }
        return ser.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent = queue.poll();
            if(!values[i].equals("#")){  
                TreeNode lnode = new TreeNode(Integer.parseInt(values[i]));
                parent.left=lnode;
                queue.add(lnode);
            }   
            if(!values[++i].equals("#")){
                TreeNode rnode = new TreeNode(Integer.parseInt(values[i]));
                parent.right=rnode;
                queue.add(rnode);
            }
        }
        return root;
    }
}
