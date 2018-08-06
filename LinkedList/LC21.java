package LinkedList;

import DFS.ListNode;

public class LC21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                head.next = l2;
                l2 = l2.next;
            }
        }
        if (l2 == null) {
            while (l1 != null) {
                head.next = l1;
                l1 = l1.next;
            }
        }
        return head;
    }


}
