package HashTable;

import java.util.ArrayList;
import java.util.HashSet;

public class LC349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        for (int n : nums1) {
            s1.add(n);
        }
        for (int n : nums2) {
            if (s1.contains(n) && s2.add(n)) {
                list.add(n);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
