package LinkedList;

import DFS.ListNode;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy1 = new ListNode(0);
        dummy1.next = head;
        ListNode tail1 = dummy1, head2, tail2 = dummy1, head3;
        int count = 0;
        while (head != null) {
            count++;
            if (count < m) {
                tail1 = head;
            }
            if (count <= n) {
                tail2 = head;
            }
            head = head.next;
        }
        head2 = tail1.next;
        head3 = tail2.next;
        ListNode dummy2 = null;
        for (int i = m; i <= n; i++) {
            ListNode tmp = head2;
            tmp.next = dummy2;
            dummy2 = tmp;
            head2 = head2.next;
        }
        ListNode tmp = head2.next;
        head2.next = dummy2;
        tmp.next = head3;
        return dummy1.next;
    }
}
