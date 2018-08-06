package HashTable;

import java.util.HashMap;

public class LC219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (position.containsKey(cur)) {
                int minus = i - position.get(cur);
                if (minus <= k) {
                    return true;
                }

            }
            position.put(cur, i);
        }
        return false;
    }
}
