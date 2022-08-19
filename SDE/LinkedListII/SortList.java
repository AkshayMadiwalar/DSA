package SDE.LinkedListII;

public class SortList {


    //merge sort
    //Time: O(nlogn)
    //Space: O(n)
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
         
         ListNode mid = getmid(head);
         ListNode left = sortList(head);
         ListNode right = sortList(mid);
         return merge(left,right);
     }
     
     public ListNode merge(ListNode left, ListNode right){
         ListNode temp = new ListNode(0);
         ListNode dummy = temp;
         while(left!=null && right !=null){
             if(left.val< right.val){
                 temp.next=left;
                 temp=temp.next;
                 left=left.next;
             }else{
                 temp.next=right;
                 temp=temp.next;
                 right=right.next;
             }
         }
         if(left==null)
             temp.next=right;
         else
             temp.next=left;
         return dummy.next;
     }
     
     public ListNode getmid(ListNode head){
         ListNode slow = head;
         ListNode fast = head;
         
         while(fast.next!=null && fast.next.next!=null){
             slow=slow.next;
             fast=fast.next.next;
         }
         
         ListNode middle = slow.next;
         slow.next = null;
         return middle;
     }
}
