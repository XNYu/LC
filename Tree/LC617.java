package Tree;

import DFS.TreeNode;

public class LC617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode head = new TreeNode(getVal(t1) + getVal(t2));
        TreeNode left, right;
        if (t1 == null && t2 == null) {
            left = null;
            right = null;
        } else {
            left = mergeTrees(getLeft(t1),getLeft(t2));
            right = mergeTrees(getRight(t1), getRight(t2));
        }
        head.left = left;
        head.right = right;
        return head;
    }

    public int getVal(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return treeNode.val;
    }

    public TreeNode getLeft(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        return treeNode.left;
    }

    public TreeNode getRight(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        return treeNode.right;
    }
}
