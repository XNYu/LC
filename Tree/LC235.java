package Tree;

import DFS.TreeNode;

public class LC235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pre = Math.min(p.val,q.val);
        int cur = Math.max(p.val,q.val);
        while (root != null) {
            if (root.val >= pre && root.val < cur) {
                return root;
            } else if (root.val < pre) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }
}
