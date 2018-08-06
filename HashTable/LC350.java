package HashTable;

import java.util.ArrayList;
import java.util.HashMap;

public class LC350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int n : nums1) {
            int count = map1.getOrDefault(n, 0);
            map1.put(n, count+1);
        }
        for (int n : nums2) {
            int count = map2.getOrDefault(n, 0);
            map2.put(n, count + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : map1.keySet()) {
            if (map2.containsKey(n)) {
                int count = Math.min(map1.get(n), map2.get(n));
                for (int i = 0; i < count; i++) {
                    list.add(n);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
