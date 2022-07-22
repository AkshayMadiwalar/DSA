package Trees;

import java.util.HashMap;

public class ConstructBinaryTreeFromInPre {
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        Node root = buildTree(inorder,0,inorder.length-1,
                                preorder,0,preorder.length,map);
                                
        return root;
    }
    
    public static Node buildTree(int inorder[], int istart,int iend,
                                int preorder[], int pstart, int pend, HashMap<Integer,Integer> map){
                                    
        if(pstart>pend || istart>iend)  
            return null;
            
        Node root = new Node(preorder[pstart]);
        
        int iroot=map.get(preorder[pstart]);
        int numsleft=iroot-istart;
        
        root.left=buildTree(inorder,istart,iroot-1,
                            preorder,pstart+1,pstart+numsleft,map);
                            
        root.right=buildTree(inorder,iroot+1,iend,
                            preorder,pstart+1+numsleft,pend,map);
                            
        return root;
                                
    }
}
