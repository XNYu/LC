package Tree;

import DFS.TreeNode;

public class LC156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightSubTree = new TreeNode(root.val);
        return go(root, rightSubTree);
    }

    public TreeNode go(TreeNode root, TreeNode rightSubTree){
        if (root.left != null) {
            TreeNode tempLeft = root.right;
            TreeNode head = new TreeNode(root.left.val);
            head.left = tempLeft;
            head.right = rightSubTree;
            return go(root.left, head);
        } else {
            return rightSubTree;
        }
    }
}
