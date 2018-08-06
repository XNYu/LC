package DFS;

public class LC129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        return sum(root, val);
    }

    public int sum(TreeNode root, int total) {
        if (root == null) {
            return 0;
        }
        total = total * 10 + root.val;
        if (isLeaf(root)) {
            return total;
        }
        return sum(root.left, total) + sum(root.right, total);
    }

    public boolean isLeaf(TreeNode root) {
        if (root.left == null && root.left == null) {
            return true;
        }
        return false;
    }
}
