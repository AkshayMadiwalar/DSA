package Trees;

import java.util.HashMap;

public class ConstructBinaryTreeFromInPost { 
     

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){       
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree(inorder,0,inorder.length-1,
                                    postorder,0,postorder.length-1,map);
        return root;
        
    }
    
    public TreeNode buildTree(int[] inorder, int istart,int iend,
                                int[] postorder, int pstart, int pend, HashMap<Integer,Integer> map){
        
        if(pstart>pend || istart>iend)  return null;
        
        TreeNode root = new TreeNode(postorder[pend]);
        int iroot = map.get(postorder[pend]);
        int numsleft = iroot-istart;
        
        root.left=buildTree(inorder,istart,iroot-1,postorder,pstart,pstart+numsleft-1,map);
        root.right=buildTree(inorder,iroot+1,iend,postorder,pstart+numsleft,pend-1,map);
        
        return root;
        
    }
}
