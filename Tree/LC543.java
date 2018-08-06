package Tree;

import DFS.TreeNode;

public class LC543 {
    int max=-1;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return max;
    }

    public int longestPath(TreeNode root) {
        if(root==null)
            return 0;
        int left = longestPath(root.left);
        int right = longestPath(root.right);
        max = Math.max(left + right, max);
        return 1 + Math.max(left, right);
    }
}
