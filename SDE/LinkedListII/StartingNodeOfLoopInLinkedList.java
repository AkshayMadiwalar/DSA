package SDE.LinkedListII;

public class StartingNodeOfLoopInLinkedList {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        if(head==null || head.next == null || head.next.next==null)
            return null;
        
        do{
            if(fast.next == null || fast.next.next==null)
                return null;
            slow=slow.next;
            fast=fast.next.next;
            
        }while(slow!=fast);
        
        fast=head;
        
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        
        return slow;
    }
}
