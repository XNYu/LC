package DFS;

import java.util.LinkedList;
import java.util.List;

public class LC257 {
    LinkedList<String> ans = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String path = "" + root.val;
        find(root.left,path);
        find(root.right,path);
        return ans;
    }

    public void find(TreeNode root, String path) {
        if(root==null)
            return;
        path += "->" + root.val;
        if (isLeaf(root)) {
            ans.add(path);
        } else {
            find(root.left,path);
            find(root.right,path);
        }
    }

    public boolean isLeaf(TreeNode root) {
        if(root.left==null&&root.right==null)
            return true;
        return false;
    }
}
