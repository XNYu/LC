package LinkedList;

import DFS.ListNode;

public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode pre = s;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }
        return s.next;
    }
}
