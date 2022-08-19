package Trees;

import java.util.*;

public class AllNodesDIstanceKFromTarget {
    HashMap<TreeNode,TreeNode> map = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        dfs(root,null);
        
        HashSet<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        seen.add(target);
        
        List<Integer> ans = new ArrayList<>();
        
        while(!queue.isEmpty()){
            if(k==0){
                //compute answer
                break;
            }
            int size = queue.size();
            
            while(size>0){
                TreeNode node = queue.poll();
                if(!seen.contains(node.left) && node.left!=null){
                    queue.add(node.left);
                    seen.add(node.left);
                }
                if(!seen.contains(node.right) && node.right!=null){
                    queue.add(node.right);
                    seen.add(node.right);
                }
                if(!seen.contains(map.get(node)) && map.get(node)!=null){
                    queue.add(map.get(node));
                    seen.add(map.get(node));
                }
                size--;
            }
            k--;
        }
        
        
        while(queue.size()>0){
            TreeNode node = queue.poll();
            if(node!=null)
                ans.add(node.val);
        }
        
        return ans;
    }
    
    public void dfs(TreeNode root,TreeNode parent){
        if(root==null)
            return;
        if(!map.containsKey(root))
            map.put(root,parent);
        dfs(root.left,root);
        dfs(root.right,root);
    }
}
