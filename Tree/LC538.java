package Tree;

import DFS.TreeNode;

import java.util.Stack;

public class LC538 {
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        int count = 0;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            int val = root.val;
            root.val += count;
            count += val;
            root = root.left;
        }
        return head;
    }

}
