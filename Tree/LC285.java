package Tree;

import DFS.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        boolean found = false;
        boolean got = false;
        List<Integer> list = new LinkedList<>();
        while (root != null || !stack.empty()) {
            list.add(root.val);
            if (found) {
                got = true;
                break;
            }
            if (root.val == p.val) {
                found = true;
            }
            while (root!= null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        if(!got)
            return null;
        else
            return root;
    }
}
