package LinkedList;

import DFS.ListNode;

public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = cur;
            }
            else
                pre.next = cur.next;
            cur = cur.next;
        }
        return dummy.next;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode pre = dummy, cur = head;
        boolean hasDuplicate = false;
        while (head != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
                cur = cur.next;
                hasDuplicate = true;
            } else {
                if (hasDuplicate) {
                    tail.next = cur;
                    tail = cur;
                    pre = cur;
                    cur = pre.next;
                } else {
                    pre = pre.next;
                    cur = pre.next;
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }
}
