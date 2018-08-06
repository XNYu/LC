package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        back(0,nums, new ArrayList<>(), new boolean[nums.length]);
        ans.add(new ArrayList<>());
        return ans;
    }

    public void back(int start, int[] num, ArrayList<Integer> list, boolean[] visited) {
        if(list.size()==num.length)
            return;
        for (int i = start; i < num.length; i++) {
            if(visited[i])
                continue;
            list.add(num[i]);
            ans.add(new ArrayList<>(list));
            visited[i] = true;
            back(i,num, list, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        LC78 l = new LC78();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(l.subsets(nums));
    }
}
