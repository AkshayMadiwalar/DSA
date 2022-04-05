package Trees;

import java.util.LinkedList;
import java.util.List;

class Solution {


    //O(n) Sngle traversal function
    public TreeNode lowestCommonAncestorDFS(TreeNode root,TreeNode p, TreeNode q){

        if(root ==null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestorDFS(root.left, p, q);
        TreeNode right = lowestCommonAncestorDFS(root.right, p, q);

        if(right == null)   return left;

        else if(left == null)    return right;

        else return root;
    }



    //Brute Force => Find two paths and get the last common element.

    List<TreeNode> p = new LinkedList<>();
    List<TreeNode> q = new LinkedList<>();
    
    TreeNode lowest = null;
    boolean found = false;
    
    public void path(TreeNode root,TreeNode find){
    
        if(root ==null){
            return;
        }
        
        if(!this.found){
            p.add(root);
        }
        
        if(root.val == find.val){
            this.found = true;
            return;
        }
        
        if(root.left!=null && !this.found) path(root.left,find);    
        if(root.right!=null && !this.found) path(root.right,find);
        if(p.size()>0 && !this.found){
             p.remove(p.size()-1);
        }
       
    }
    
     public void pathq(TreeNode root,TreeNode find){
    
        if(root == null){
            return;
        }
        
        if(!this.found)
            q.add(root);
         
        if(root.val == find.val){
            this.found = true;
            return;
        }

 
        if(root.left!=null && !this.found) pathq(root.left,find);
        if(root.right!=null && !this.found)  pathq(root.right,find);
          
         if(q.size()>0 && !this.found){
                q.remove(q.size()-1);
         }
        
    }

    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path(root,p);
        this.found = false;
        pathq(root,q);
        
        TreeNode lowest = null;
        
        if(this.p.size()>this.q.size()){
              for(int i = 0;i<this.p.size();i++){
                if(this.q.contains(this.p.get(i))){
                    lowest = this.p.get(i);
                }
              }
        }else{
            for(int i = 0;i<this.q.size();i++){
                if(this.p.contains(this.q.get(i))){
                    lowest = this.q.get(i);
                }
            }
        }
      
        
        return lowest;
    }
}