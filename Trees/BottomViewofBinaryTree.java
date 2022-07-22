package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    Node node;
    int level;
    Pair(Node node,int level){
        this.node=node;
        this.level=level;
    }
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        HashMap<Integer,Integer> map =new HashMap<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(root,0));
        
        while(!queue.isEmpty()){
            Pair pair =  queue.poll();
            
            map.put(pair.level,pair.node.data);
            min=Math.min(min,pair.level);
            max=Math.max(max,pair.level);
            
            Node node = pair.node;
            
            if(node.left!=null){
                queue.add(new Pair(node.left,pair.level-1));
            }
            if(node.right!=null){
                queue.add(new Pair(node.right,pair.level+1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=min;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
    
}