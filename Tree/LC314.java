package Tree;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC314 {
    List<List<int[]>> ans = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    public List<List<Integer>>verticalOrder(TreeNode root) {
        level(root, 0,0);
        List<List<Integer>> answer = new ArrayList<>();
        int w = max-min;
        List[] a = new ArrayList[w+1];
        Arrays.fill(a,new ArrayList<Integer>());
        for (List<int[]> level : ans) {
            for (int[] node : level) {
                int value = node[0];
                int width = node[1] - min;
                ArrayList<Integer> list = new ArrayList<Integer>(a[width]);
                list.add(value);
                a[width] = list;
            }
        }
        for (List list : a) {
            answer.add(list);
        }
        return answer;
    }

    public void level(TreeNode root, int depth, int width) {
        if(root==null)
            return;
        ArrayList<int[]> list;
        if (ans.size() < depth+1)
        {
            list = new ArrayList<>();
            list.add(new int[]{root.val,width});
            ans.add(list);
        }
        else
        {
            list = (ArrayList<int[]>) ans.get(depth);
            list.add(new int[]{root.val,width});
            ans.set(depth, list);
        }
        max = Math.max(max, width);
        min = Math.min(min, width);
        level(root.left, depth + 1,width-1);
        level(root.right, depth + 1,width+1);
    }
}
