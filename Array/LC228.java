package Array;

import java.util.ArrayList;
import java.util.List;

public class LC228 {
    public List<String> summaryRanges(int[] nums) {
        int start, end;
        int pre = nums[0];
        start = pre;
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur != pre + 1) {
                end = pre;
                if (end != start)
                    ans.add(start + "→" + end);
                else
                    ans.add("" + end);
                start = cur;
            }
            pre = cur;
        }
        end = nums[nums.length - 1];
        if (end == start) {
            ans.add("" + end);
        } else {
            ans.add(start + "→" + end);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC228 l = new LC228();
        System.out.println(l.summaryRanges(new int[]{1,2,3,4,5}));
    }
}
