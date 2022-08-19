package SDE.LinkedListII;

public class PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return head;
        ListNode before = null;
        ListNode after = null;
        
        ListNode beforeHead = head;
        ListNode afterHead = null;
        
        ListNode node = head;
        while(node!=null){
            if(node.val<x){
                if(before==null) {
                    before = new ListNode(node.val);
                    beforeHead = before;
                }
                else{
                    before.next = new ListNode(node.val);
                    before = before.next;
                }
                
            }
            else if(node.val>=x){
                if(after==null) {
                    after = new ListNode(node.val);
                    afterHead = after;
                }
                else{
                    after.next=new ListNode(node.val);
                    after=after.next;
                }
            }
            
            node=node.next;
        }
        if(before!=null)
            before.next=afterHead;
        return beforeHead;
    }
}
