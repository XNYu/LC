package HashTable;

import java.util.Arrays;

public class LC645 {
    public int[] findErrorNums(int[] nums) {
        int more = -1;
        Arrays.sort(nums);
        boolean first = false;
        int lose = -1;
        if(nums[0]!=1) {
            lose = 1;
            first = true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (!first && nums[i] != i) {
                first = true;
                more = nums[i];
            }
            if (first && nums[i] == i) {
                lose = i;
            }
        }
        return new int[]{more,lose};
    }
}
