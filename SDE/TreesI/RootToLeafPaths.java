package SDE.TreesI;

import java.util.ArrayList;

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

public class RootToLeafPaths {
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<ArrayList<Integer>> ans =  new ArrayList<>();
        pathSum(root,new ArrayList<>(),ans);
        return ans;
    }
    
    public void pathSum(Node root,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> ans){
    
        if(root==null)
            return;
            
        path.add(root.data); 
        
        if(root.left==null && root.right==null)
            ans.add(new ArrayList<>(path));
           
   
        
        pathSum(root.left,path,ans);
        pathSum(root.right,path,ans);
        path.remove(path.size()-1);
    }
    
}
