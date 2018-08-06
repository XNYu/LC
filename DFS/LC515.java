package DFS;

import DFS.TreeNode;

import java.util.*;

public class LC515 {
    ArrayList<Integer> ans = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        largest(root, 0);
        return ans;
    }

    public void largest(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (ans.size() < depth) {
            ans.add(root.val);
        } else {
            if (ans.get(depth)<root.val) {
                ans.set(depth,root.val);
            }
        }
        largest(root.left,depth+1);
        largest(root.right, depth + 1);
    }
}
