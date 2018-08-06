package Tree;

import DFS.TreeNode;

public class LC404 {
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        tra(root,false);
        return ans;
    }

    public void tra(TreeNode root, boolean left) {
        if (root == null) {
            return;
        }
        if (left && leaf(root)) {
            ans += root.val;
        }
        tra(root.left, true);
        tra(root.right, false);
    }

    public boolean leaf(TreeNode root){
        if (root.left==null&&root.right==null)
            return true;
        return false;
    }
}
