package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair{
    int v;
    TreeNode node;
    Pair(int v,TreeNode node){
        this.v = v;
        this.node = node;
    }
}


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       Queue<Pair> queue = new LinkedList<>();
       queue.add(new Pair(0,root));
        
       HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        List<List<Integer>> ans = new LinkedList<>();
    
        int min_vt = 0;
        int max_vt = 0;
        
        
       while(!queue.isEmpty()){
           int size = queue.size();
           
           while(size>0){
               Pair pair = queue.remove();
               //queue.poll();
               TreeNode node = pair.node;
               int vt = pair.v;
               
               if(min_vt > vt){
                   min_vt = vt;
               }
               
               if(max_vt < vt){
                   max_vt = vt;
               }
               if(map.get(vt)!=null){
                   List<Integer> list = map.get(vt);
                   list.add(node.val);
                   map.put(vt,list);
               }else{
                   List<Integer> list = new ArrayList<>();
                   list.add(node.val);
                   map.put(vt,list);
               }
               if(node.left!=null){
                   queue.add(new Pair(vt-1,node.left));
               }
               
               if(node.right!=null){
                   queue.add(new Pair(vt+1,node.right));
               }
               size--;
           }
       } 
        
        
        for(int i=min_vt;i<=max_vt;i++){
           List<Integer> list = map.get(i);
           ans.add(list); 
        }
        
        return ans;
    }
}
