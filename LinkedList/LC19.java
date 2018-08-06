package LinkedList;

import DFS.ListNode;

import java.util.Stack;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        ListNode nxt = new ListNode(0);
        for (int i = 0; i < n; i++) {
            nxt = stack.pop();
        }
        if (stack.size() > 0) {
            ListNode pre = stack.pop();
            pre.next = nxt.next;
        } else {
            head = nxt.next;
        }
        return head;
    }
}
