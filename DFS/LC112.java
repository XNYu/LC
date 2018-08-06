package DFS;

public class LC112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && isLeaf(root)) {
            return true;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }

    public boolean isLeaf(TreeNode root) {
        if(root.left==null&&root.right==null)
            return true;
        return false;
    }
}
