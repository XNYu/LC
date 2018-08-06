package LinkedList;

import DFS.ListNode;

public class LC25 {
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode fake = new ListNode(-1);
        fake.next = dummy;
        dummy.next = head;
        ListNode cur = head;
        ListNode left = head;
        int count = 0;
        while (cur!=null) {
            while (count < k && cur != null) {
                cur = cur.next;
                count++;
            }
            ListNode tmp=null;
            while (count > 0) {
                tmp = left.next;
                left.next = cur;
                cur = left;
                left = tmp;
                count--;
            }
            dummy.next = cur;
            cur = tmp;
            while (count < k && cur != null) {
                dummy = dummy.next;
                count++;
            }


        }
        return fake.next.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode fake = new ListNode(-1);
        fake.next = dummy;
        dummy.next = head;
        ListNode cur = head;
        ListNode left = head;
        int count = 0;
        while (cur != null && count < k) {
            count++;
            cur = cur.next;
        }
        while (cur!=null) {
            ListNode tmp=null;
            while (count > 0) {
                tmp = left.next;
                left.next = cur;
                cur = left;
                left = tmp;
                count--;
            }
            dummy.next = cur;
            cur = tmp;
            while (count < k && cur != null) {
                dummy = dummy.next;
                cur = cur.next;
                count++;
            }
        }
        if (count==k) {
            for (int i = 0; i < k; i++) {
                ListNode tmp = left.next;
                left.next = cur;
                cur = left;
                left = tmp;
            }
            dummy.next = cur;
        }
        return fake.next.next;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode head = new ListNode(1);
        dummy.next = head;
        for (int i = 2; i < 10; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode cur = dummy.next;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
        LC25 l = new LC25();
        ListNode ans = l.reverseKGroup2(dummy.next, 3);
        while (ans != null) {
            System.out.print(ans.val+" ");
            ans = ans.next;
        }
    }
}
