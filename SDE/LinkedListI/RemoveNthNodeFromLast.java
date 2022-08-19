package SDE.LinkedListI;

public class RemoveNthNodeFromLast {

    class ListNode {
           int val;
         ListNode next;
         ListNode(int x) {
              val = x;
               next = null;
          }
          
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast = head;
        ListNode slow = null;
        
        int i = 1;
        while(fast!=null && i<=n){
            fast=fast.next;
            i++;
        }
        
        while(fast!=null){
            if(slow==null){
                slow=head;
            }else{
                slow=slow.next;   
            }
            fast=fast.next;
        }
    
        if(slow!=null){
            slow.next = slow.next.next;
        }else{
            head = head.next;
        }
 
    
        
            return head;
    }
}
