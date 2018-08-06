package Tree;

import DFS.TreeNode;

public class LC250 {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        find(root);
        return count;
    }

    public boolean find(TreeNode root){
        if (root == null) {
            return true;
        }
        boolean l = find(root.left);
        boolean r = find(root.right);
        if ((root.left == null || (l && root.val == root.left.val))&&(root.right == null || (r && root.val == root.right.val)))
        {
            count++;
            return true;
        }
        return false;
    }
}
