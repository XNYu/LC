package LinkedList;

import DFS.ListNode;

public class LC86 {
    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        ListNode cur = new ListNode(0);
        ListNode before = new ListNode(0);
        before = pre;
        ListNode after = new ListNode(0);
        after = cur;
        while (head != null) {
            if (head.val < x) {
                pre.next = head;
                pre = pre.next;
            } else {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        cur.next = null;
        pre.next = after.next;
        return before.next;
    }
}
