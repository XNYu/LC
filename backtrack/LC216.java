package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC216 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        back(1, k, n, new boolean[10],0);
        return ans;
    }

    public void back(int start, int k, int n, boolean[] visited, int sum) {
        if (k == 0 && sum==n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= 9; i++) {
                if(visited[i])
                    list.add(i);
            }
            ans.add(list);
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (sum + i <= n && !visited[i]) {
                visited[i] = true;
                back(i,k - 1, n, visited, sum + i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        LC216 l = new LC216();
        System.out.println(l.combinationSum3(4,4));
    }
}
