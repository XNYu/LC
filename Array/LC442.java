package Array;

import java.util.ArrayList;
import java.util.List;

public class LC442 {
    public List<Integer> findDuplicates(int[] nums) {
        Helper h = new Helper();
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int cur = nums[i];
            while (cur != nums[cur - 1]) {
                swap(i,cur-1,nums);
                cur = nums[i];
            }
            h.print(nums);
            i++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(nums[j]);
            }
        }
        return ans;
    }

    public void swap(int i, int j, int[] nums) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        LC442 l = new LC442();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(l.findDuplicates(nums));
    }


}
