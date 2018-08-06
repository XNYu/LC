package LinkedList;

import DFS.ListNode;

import java.util.Stack;

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Stack<ListNode> stack = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        for (ListNode l : lists) {
            stack.push(l);
        }
        while (s2.size() + stack.size() > 1) {
            while (stack.size()>1) {
                s2.push(merge(stack.pop(), stack.pop()));
            }
            if (!stack.empty()) {
                s2.push(stack.pop());
            }
            while (s2.size() > 1) {
                stack.push(merge(s2.pop(), s2.pop()));
            }
            if (!s2.empty()) {
                stack.push(s2.pop());
            }
        }
        if (!s2.empty()) {
            return s2.pop();
        }
        if (!stack.empty()) {
            return stack.pop();
        }
        return null;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            } else {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }
        while (l1 != null) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null) {
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return cur.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-2), l2 = new ListNode(-1);
        ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
        dummy1.next = l1;
        dummy2.next = l2;
        for (int i = 1; i < 8; i+=2) {
            l2.next = new ListNode(i - 1);
            l2 = l2.next;
            l1.next = new ListNode(i);
            l1 = l1.next;
        }
        LC23 l = new LC23();
        ListNode head = l.merge(dummy1.next, dummy2.next);

        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
