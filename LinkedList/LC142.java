package LinkedList;

import DFS.ListNode;

public class LC142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int f = 0, s = 0;
        boolean hasCycle = false;
        while (slow != null && fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            f += 2;
            s += 1;
            if(slow==fast)
            {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        int cycleLen = f - s;
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
