package backtrack;

import java.util.*;

public class LC39 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new LinkedList<>());
        return ans;
    }

    public void backtrack(int[] candidates, int target, int start, List<Integer> list) {
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            System.out.println(list);
            System.out.println(target+","+i);
            int tmp = target - candidates[i];
            if (tmp == 0)
                ans.add(new LinkedList<>(list));
            if (tmp > 0)
                backtrack(candidates, tmp, i, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC39 l = new LC39();
        int[] candidates = new int[]{2, 3, 6, 7};
        System.out.println(l.combinationSum(candidates,7));
    }
}
