package DFS;

import Contest.LC812;

import java.util.Stack;

public class LC116 {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else if (root.next != null) {
                if (root.next.left != null) {
                    root.left.next = root.next.left;
                } else if (root.next.right != null) {
                    root.left.next = root.next.right;
                }
            }
        }
        if (root.right != null) {
            if (root.next != null) {
                if (root.next.left != null) {
                    root.right.next = root.next.left;
                } else if (root.next.right != null) {
                    root.right.next = root.next.right;
                }
            }
        }
        connect(root.left);
        connect(root.right);
        return;
    }

    public void c(TreeLinkNode root) {

    }


    public static void main(String[] args) {
        LC116 l = new LC116();
        TreeLinkNode t = new TreeLinkNode(1);

    }
}
