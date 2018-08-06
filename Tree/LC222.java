package Tree;

import DFS.TreeNode;

public class LC222 {
    int depth = -1;
    int lastLayer = 1;
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
