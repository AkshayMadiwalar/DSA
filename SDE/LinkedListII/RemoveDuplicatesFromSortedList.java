package SDE.LinkedListII;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next ==null)
            return head;
        
        ListNode i = head;
        ListNode j = head.next;
        
        while(j!=null){
            if(j.val == i.val){
                i.next = j.next;
                j=j.next;
            }
            else{
                i=j;
                j=j.next;
            }
        }
        
        return head;
    }
}
