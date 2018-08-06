package DFS;

import java.util.Arrays;
import java.util.HashMap;

public class LC494 {
    HashMap<Integer, Integer>[] dp;
    public int findTargetSumWays(int[] nums, int S) {
        dp = new HashMap[nums.length];
        Arrays.fill(dp, new HashMap<>());
        return find(nums, nums.length - 1, S);
    }
    public int find(int[] nums, int e, int T) {
        int cur = nums[e];
        HashMap<Integer,Integer> map = dp[e];
        if (map.containsKey(T)) {
            return map.get(T);
        }
        int total = 0;
        if (e==0) {
            if(T==cur)
                total += 1;
            if(T==-cur)
                total += 1;
            return total;
        }
        total += find(nums, e - 1, T - cur) + find(nums, e - 1, T + cur);
        map.put(T, total);
        dp[e] = map;
        return total;
    }
}
