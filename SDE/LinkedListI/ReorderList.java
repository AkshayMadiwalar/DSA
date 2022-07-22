package SDE.LinkedListI;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode second = slow.next;
        slow.next=null;
        ListNode first = head;
        
        ListNode prev = null;
        ListNode node = second;
        while(node!=null){
            ListNode next = node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        second = prev;
        
        while(second!=null){
            ListNode fnext = first.next;
            ListNode snext = second.next;
            second.next = first.next;
            first.next=second;
            first=fnext;
            second=snext;
        }
    }
}
