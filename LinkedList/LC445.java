package LinkedList;

import DFS.ListNode;

import java.util.Stack;

public class LC445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>(), s2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2);
                l2 = l2.next;
            }
        }
        int carry = 0;
        ListNode tail = null;
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) {
                carry += s1.pop().val;
            }
            if (!s2.empty()) {
                carry += s2.pop().val;
            }
            ListNode cur = new ListNode(carry % 10);
            carry = carry / 10;
            cur.next = tail;
            tail = cur;
        }
        if (carry == 1) {
            ListNode head = new ListNode(1);
            head.next = tail;
            tail = head;
        }
        return tail;
    }
}
