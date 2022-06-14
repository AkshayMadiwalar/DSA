package SDE.LinkedListII;
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}

public class FlattenLinkedList {
    Node merge(Node a,Node b){
        if(a==null) return b;
        else if(b==null) return a;
        
        Node temp = new Node(0);
        Node res = temp;
        
        while(a!=null && b!=null){
            if(a.data<b.data){
                temp.bottom=a;
                temp=temp.bottom;
                a=a.bottom;
            }
            else{
                temp.bottom=b;
                temp=temp.bottom;
                b=b.bottom;
            }
        }
        
        if(a!=null) temp.bottom=a;
        if(b!=null) temp.bottom=b;
        
        return res.bottom;
    }
    
    Node flatten(Node root)
    {
	// Your code here
	    if(root==null || root.next==null){
	        return root;
	    }
	    root.next = flatten(root.next);
	    root = merge(root,root.next);
	    return root;
    }
}
