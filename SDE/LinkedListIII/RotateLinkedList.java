package SDE.LinkedListIII;

class ListNode {
    int val;
  ListNode next;
  ListNode(int x) {
       val = x;
        next = null;
   }
   
}

public class RotateLinkedList {
    
    public ListNode rotateRight(ListNode head, int k) {
        int len=1;
        ListNode  cur = head;
        
        if(head==null || head.next==null)   return head;
        
        while(cur.next!=null){
            cur=cur.next;
            len++;
        }
        
        k=k%len;
        k=len-k;
        
        cur = head;
        ListNode prev = null;
        
        while(k>0){
            prev=cur;
            cur=cur.next;
            k--;
        }
        
        if(cur==null)
            return head;
        
        ListNode newhead =cur;
        
        while(cur.next!=null){
            cur=cur.next;
        }
        
        
        cur.next=head;
        prev.next=null;
        
        return newhead;
    }
}
