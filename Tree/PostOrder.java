package Tree;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        recursive(root);
        return ans;
    }

    public List<Integer> iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> lstack = new Stack<>();
        Stack<TreeNode> rstack = new Stack<>();
        while (!lstack.empty()|| !rstack.empty() || root != null) {
            if (root.left != null && lstack.peek()!=root) {
                lstack.push(root);
                root = root.left;
            } else if (root.right != null && rstack.peek()!=root) {
                rstack.push(root);
                root = root.right;
            } else {
                ans.add(root.val);
                if (!rstack.empty())
                {
                    root = rstack.pop();
                }
            }
        }
        return ans;
    }

    public void recursive(TreeNode root) {
        if(root==null)
            return;
        recursive(root.left);
        recursive(root.right);
        ans.add(root.val);
    }
}
