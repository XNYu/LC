package Tree;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        recursive(root);
        return ans;
    }

    public List<Integer> iterative(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                ret.add(root.val);
                stack.push(root);
                root = root.left;
            }
            while (!stack.empty()) {
                root = stack.pop();
            }
            root = root.right;
        }
        return ret;
    }

    public void recursive(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        recursive(root.left);
        recursive(root.right);
    }
}
