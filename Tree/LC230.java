package Tree;

import DFS.TreeNode;

import java.util.Stack;

public class LC230 {
    int count = 0;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if(count==k)
                break;
            root = root.right;
        }
        return root.val;
    }

//    public void find(TreeNode root, int k) {
//        if (root == null) {
//            return;
//        }
//        find(root.left,k);
//        count++;
//        if(count==k)
//            ans =
//    }


}
