package SDE.LinkedListI;

public class ReverseLinkedList_PositionLeftToRight {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
 
        ListNode node = head;
        ListNode before = null;
        
        int i=1;
        
        while(node!=null){
            if(i==left){
                ListNode startNode = node;
                ListNode prev = null;
                while(i!=right+1){
                    ListNode next = startNode.next;
                    startNode.next=prev;
                    prev=startNode;
                    startNode=next;
                    i++;
                }
                node.next=startNode;
                if(before!=null) before.next=prev;
                if(left==1)
                    head=prev;
            }
            before = node;
            node=node.next;
            i++;
        }
        
   
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
