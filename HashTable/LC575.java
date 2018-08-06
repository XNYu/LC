package HashTable;

import java.util.HashSet;

public class LC575 {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        int len = candies.length;
        for (int i : candies) {
            set.add(i);
        }
        return Math.min(len / 2, set.size());
    }
}
