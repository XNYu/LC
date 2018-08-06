package LinkedList;

import DFS.ListNode;

public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len =0;
        ListNode tail = head;
        while (head != null) {
            len++;
            tail = head;
            head = head.next;
        }
        head = dummy.next;
        k = k % len;
        k = len - k;
        for (int i = 0; i < k-1; i++) {
            head = head.next;
        }
        if(head.next==null)
            return dummy.next;
        ListNode d2 = new ListNode(0);
        d2.next = head.next;
        head.next = null;
        tail.next = dummy.next;
        return d2.next;

    }
}
