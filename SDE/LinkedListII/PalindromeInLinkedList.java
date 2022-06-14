class ListNode {
    int val;
  ListNode next;
  ListNode(int x) {
       val = x;
        next = null;
   }
   
}
public class PalindromeInLinkedList {
     
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null) {
         ListNode next = head.next;
         head.next = prev;
         prev = head;
         head = next;
    }
    return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        if(head==null || head.next==null)
            return true;
        
        if(head.next.next==null)
            return head.val==head.next.val;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        slow.next = reverse(slow.next);
        
        slow=slow.next;
        while(slow!=null){
            if(head.val!=slow.val)
                return false;
            head=head.next;
            slow=slow.next;
        }
        return true;
    }
}
