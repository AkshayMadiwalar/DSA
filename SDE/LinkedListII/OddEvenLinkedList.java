package SDE.LinkedListII;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return head;
        
        ListNode oddHead = head.next;
        ListNode odd = head.next;
        ListNode even = head;
        
        ListNode lasteven=null;
        
        while(odd!=null && even!=null){
            ListNode evennext = (even.next==null || even.next.next==null)?null:even.next.next;
            ListNode oddnext = (odd.next==null||odd.next.next==null)?null:odd.next.next;
            even.next= evennext;
            odd.next= oddnext;
            lasteven=even;
            even=evennext;
            odd=oddnext;
        }
        
        if(even==null)
            lasteven.next=oddHead;
        else
        even.next=oddHead;
        
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}