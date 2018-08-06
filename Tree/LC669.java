package Tree;

import DFS.TreeNode;

public class LC669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null)
            return null;
        TreeNode left = trimBST(root.left, L, R);
        TreeNode right = trimBST(root.right, L, R);
        if (root.val < L) {
            return left;
        }
        else if(root.val>R)
            return right;
        else
        {
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
