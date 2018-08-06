package DFS;

import sun.reflect.generics.tree.Tree;

public class LC114 {
    public void flatten(TreeNode root) {
        TreeNode now = root;
        while (now != null) {
            if (now.left != null) {
                TreeNode pre = now.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = now.right;
                now.right = now.left;
                now.left = null;
            }
            now = now.right;
        }
    }

}
