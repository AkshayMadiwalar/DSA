package SDE.LinkedListII;

public class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode groupPrev = dummy;
        
        while(true){
            ListNode kth = getKthNode(groupPrev,k);
            if(kth==null)
                break;
            ListNode groupNext = kth.next;
            
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            
            while(curr!=groupNext){
                ListNode next = curr.next;
                curr.next = prev;
                prev= curr;
                curr = next;
            }
            
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
            
        }
        return dummy.next;
    }
    

    
    public ListNode getKthNode(ListNode node, int k){
        while(node!=null && k>0){
            node=node.next;
            k--;
        }
        return node;
    }
}
