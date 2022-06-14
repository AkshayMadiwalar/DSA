package SDE.LinkedListII;

public class IntersectionOfTwoLinkedLists {
    
    class ListNode {
        int val;
      ListNode next;
      ListNode(int x) {
           val = x;
            next = null;
       }
       
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        
        int i=0;
        
        while(a!=b && i<2){
            
            if(a==null){
                a=headB;
            }else{
                a=a.next;
            }
            
            if(b==null){
                b=headA;
            }else{
                b=b.next;
            }
        }
        
        return a;
    }
}
