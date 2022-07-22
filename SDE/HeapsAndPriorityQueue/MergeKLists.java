package SDE.HeapsAndPriorityQueue;

import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        PriorityQueue<Pair<Integer,ListNode>> pq = new PriorityQueue<Pair<Integer,ListNode>>(lists.length,(a,b)->a.getKey()-b.getKey());
        
        for(int i=0;i<lists.length;i++){
            ListNode node = lists[i];
            if(node!=null)
                pq.add(new Pair(node.val,node));    
        }
        
        ListNode dummy   = new ListNode(0);
        ListNode temp = dummy;
        
        while(pq.size()>0){
            Pair<Integer,ListNode> pair = pq.poll();
            
            temp.next = new ListNode(pair.getKey());
            temp = temp.next;
            ListNode node = pair.getValue();
            node = node.next;
            if(node!=null)
                pq.add(new Pair(node.val,node));
        }
        
        return dummy.next;
    }
}




class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
