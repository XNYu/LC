package LinkedList;

import DFS.ListNode;

public class LC143 {
    public void reorderList(ListNode head) {
        ListNode before = new ListNode(0);
        before.next = head;
        ListNode slow = before, fast = before;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = slow.next;
        slow.next = null;
        ListNode dummy = null;
        ListNode after = new ListNode(0);
        while (half != null) {
            after = half;
            after.next = dummy;
            dummy = after;
            half = half.next;
        }
        while (after != null) {
            ListNode tmp = head.next;
            head.next = after;
            after = after.next;
            head.next.next = tmp;
        }
    }
}
