package Tree;

import DFS.TreeNode;

import java.util.HashSet;

public class LC653 {
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        set.add(root.val);
        if (set.add(k - root.val)) {
            return true;
        }
        return findTarget(root.left, k) || findTarget(root.right, k);
    }


}
