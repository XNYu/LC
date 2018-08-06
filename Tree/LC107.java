package Tree;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC107 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        level(root, 1);
        Collections.reverse(ans);
        return ans;
    }

    public void level(TreeNode root, int depth) {
        if(root==null)
            return;
        ArrayList<Integer> list;
        System.out.println(root.val+","+ans.size());
        if (ans.size() < depth)
        {
            list = new ArrayList<>();
            list.add(root.val);
            ans.add(list);
        }
        else
        {
            list = (ArrayList<Integer>) ans.get(depth - 1);
            list.add(root.val);
            ans.set(depth - 1, list);
        }
        level(root.left, depth + 1);
        level(root.right, depth + 1);
    }
}
