package DFS;

import java.util.*;

public class LC366 {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        process(root);
        return ans;
    }

    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (!isLeaf(root)) {
            depth = Math.max(process(root.left), process(root.right)) + 1;
        }
        if (ans.size() <= depth) {
            list.add(root.val);
            ans.add(list);
        } else {
            list = (LinkedList<Integer>) ans.get(depth);
            list.add(root.val);
            ans.set(depth, list);
        }
        return depth;
    }

    public boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}
