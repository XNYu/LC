package LinkedList;

import DFS.ListNode;

public class LC24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre;
        while (pre != null && pre.next != null && pre.next.next != null) {
            ListNode tmp = pre.next;
            ListNode cur = pre.next.next.next;
            pre.next = pre.next.next;
            pre.next.next = tmp;
            pre.next.next.next = cur;
            pre = pre.next.next;
        }
        return start.next;
    }
}
