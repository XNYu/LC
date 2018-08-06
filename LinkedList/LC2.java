package LinkedList;

import DFS.ListNode;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode head = start;
        int cur=0,pre=0;
        while (l1 != null && l2 != null) {
            cur = l1.val + l2.val + pre;
            if (cur >= 10) {
                cur = cur - 10;
                pre = 1;
            }
            ListNode l = new ListNode(cur);
            head.next = l;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            ListNode l = new ListNode(l1.val+pre);
            head.next = l;
            head = head.next;
            l1 = l1.next;
            pre = 0;
        }
        while (l2 != null) {
            ListNode l = new ListNode(l2.val+pre);
            head.next = l;
            head = head.next;
            l2 = l2.next;
            pre = 0;
        }
        if (pre == 1) {
            ListNode l = new ListNode(pre);
            head.next = l;
        }
        return start;
    }
}
