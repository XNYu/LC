package LinkedList;

import DFS.ListNode;

public class LC147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        ListNode ans = new ListNode(head.val);
        pre.next = ans;
        while (true) {
            head = head.next;
            if (head == null)
                break;
            ListNode cur = pre.next;
            ListNode before = pre;
            while (cur != null && cur.val > head.val) {
                before = before.next;
                cur = cur.next;
            }
            ListNode insert = new ListNode(head.val);
            before.next = insert;
            insert.next = cur;
        }
        return pre.next;
    }

}
