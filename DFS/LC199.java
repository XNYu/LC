package DFS;

import java.util.*;

public class LC199 {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        right(root, 0);
        return list;
    }

    public void right(TreeNode root, int depth) {
        if (list.size() > depth) {
            list.set(depth, root.val);
        }
        else
            list.add(root.val);
        right(root.left,depth+1);
        right(root.right,depth+1);
    }
}
