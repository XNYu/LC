package LinkedList;

import DFS.ListNode;

public class LC328 {
    public ListNode oddEvenList(ListNode head) {
        int index = 1;
        ListNode start = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        if (even != null) {
            head = head.next.next;
        } else {
            head = head.next;
        }
        while (head != null) {
            if (index % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            index++;
        }
        odd.next = start;
        return start;
    }
}
