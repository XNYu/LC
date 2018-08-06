package Tree;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC637 {
    ArrayList<Long> total = new ArrayList<>();
    ArrayList<Integer> count = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        traverse(root, 0);
        ArrayList<Double> ans = new ArrayList<>();
        for (int i = 0; i < total.size(); i++) {
            double avg = (double) total.get(i) / count.get(i);
            ans.add(avg);
        }
        return ans;
    }

    public void traverse(TreeNode root, int depth) {
        if(root==null)
            return;
        if (total.size() <= depth) {
            total.add((long)root.val);
            count.add(1);
        } else {
            total.set(depth, total.get(depth) + root.val);
            count.set(depth, count.get(depth) + 1);
        }
        traverse(root.left,depth+1);
        traverse(root.right, depth + 1);
    }
}
