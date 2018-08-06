package HashTable;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LC508 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        find(root);
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry e : map.entrySet()) {
            if ((int)e.getValue() == max) {
                ans.add((Integer) e.getKey());
            }
        }
        int[] a = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }
        return a;
    }

    public int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = root.val + find(root.left) + find(root.right);
        int count = map.getOrDefault(ans, 0);
        count += 1;
        max = Math.max(max, count);
        map.put(ans, count);
        return ans;
    }
}
