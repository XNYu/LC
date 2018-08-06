package DFS;

import java.util.List;

public class LC109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return BST(head,null);
    }

    public TreeNode BST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode left = BST(head, slow);
        TreeNode right = BST(slow.next, tail);
        TreeNode thead = new TreeNode(slow.val);
        thead.left = left;
        thead.right = right;
        return thead;
    }
}
