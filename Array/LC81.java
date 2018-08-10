package Array;

import java.util.HashSet;

public class LC81 {
    public boolean search(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i:nums) {
            set.add(i);
        }
        return set.contains(target);
    }
}
