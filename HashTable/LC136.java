package HashTable;

import java.util.HashMap;

public class LC136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }
        for (Integer e : map.keySet()) {
            if (map.get(e)== 1) {
                return e;
            }
        }
        return 0;
    }
}
