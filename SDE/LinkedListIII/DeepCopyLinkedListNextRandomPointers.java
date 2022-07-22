package SDE.LinkedListIII;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCopyLinkedListNextRandomPointers {
    public Node copyRandomList(Node head) {
        Node iter = head;
        Node seconditer=null;
            
        while(iter!=null){
            seconditer=iter.next;
            Node copy = new Node(iter.val);
            copy.next=seconditer;
            iter.next=copy;
            iter=seconditer;
        }
        
        iter=head;
        while(iter!=null){
            if(iter.random != null)
                iter.next.random=iter.random.next;

            iter=iter.next.next;
        }
        
        iter=head;
        Node copy = new Node(0);
        Node clone = copy;
        Node front = null;
        while(iter!=null){
            front=iter.next.next;
       
            clone.next=iter.next;
            
            iter.next=front;
            clone=clone.next;
            
            iter=iter.next;
        }
        
        return copy.next;
    }
}
