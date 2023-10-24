   public ListNode deleteMiddle(ListNode head) {
        ListNode dummy  = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }