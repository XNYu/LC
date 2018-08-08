package HashTable;

import java.util.HashMap;

public class LC325 {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            sum += cur;
            if(!map.containsKey(sum))
                map.put(sum, i);
            if (map.containsKey(sum - k)) {
                max = Math.max(i - map.get(sum - k), max);
            }
        }
        return max;
    }
}
