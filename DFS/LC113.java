package DFS;

import java.util.LinkedList;
import java.util.List;

public class LC113 {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> PathSum(TreeNode root, int sum) {
        find(root, sum, new LinkedList<>());
        return ans;
    }

    public void find(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        LinkedList<Integer> l = new LinkedList<>(list);
        l.add(root.val);
        if (root.val == sum && isLeaf(root)) {
            ans.add(l);
        }
        sum = sum - root.val;
        find(root.left, sum, l);
        find(root.right, sum, l);
    }

    public boolean isLeaf(TreeNode root) {
        if(root.left==null&&root.right==null)
            return true;
        return false;
    }

    public static void main(String[] args) {
        LC113 l = new LC113();

    }
}
