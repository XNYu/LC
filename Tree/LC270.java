package Tree;

import DFS.TreeNode;

public class LC270 {
    double minus = Double.MAX_VALUE;
    int ans = 0;
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        double m = Math.abs(root.val - target);
        if (m < minus) {
            minus = m;
            ans = root.val;
        }
        if (root.val < target) {
            closestValue(root.right, target);
        } else if(root.val>target) {
            closestValue(root.left, target);
        }
        return ans;

    }

}
