package SDE.LinkedListI;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode node = head;
        while(node!=null){
            ListNode next = node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        
        return prev;
    }
}
