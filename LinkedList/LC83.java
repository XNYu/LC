package LinkedList;

import DFS.ListNode;

public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode s = head;
        while (head != null&&head.next!=null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return s;
    }
}
