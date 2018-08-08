package HashTable;

import java.util.HashMap;

public class LC525 {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int len = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                sum--;
            } else {
                sum++;
            }
            if (map.containsKey(sum)) {
                max = Math.max(i - map.get(sum) + 1, max);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
