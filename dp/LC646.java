package dp;

import java.util.Arrays;

public class LC646 {
    int[] dp;
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        if (len<2)
            return len;
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int count=1;
        for (int i = 1; i < len; i++) {

        }
        return 0;
    }
}
