package LinkedList;

import DFS.ListNode;

public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode bkA = headA;
        ListNode bkb = headB;
        int lenA = 0;
        int lenB = 0;

        while (bkA != null) {
            lenA++;
            bkA = bkA.next;
        }
        while (bkb != null) {
            lenB++;
            bkb = bkb.next;
        }
        ListNode end = bkA;
        bkA.next = headB;

        bkA = headA;
        bkb = headA;

        while (lenB > 0) {
            bkb = bkb.next;
            lenB--;
        }
        while (lenA > 0) {
            bkA = bkA.next;
            bkb = bkb.next;
            lenA--;
        }
        end.next = null;
        if (bkb == bkA) {
            return bkb;
        } else {
            return null;
        }

    }

}
