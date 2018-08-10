package Array;

import java.util.Arrays;

public class LC628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        int max1 = nums[0] * nums[1] * nums[nums.length - 1];
        int max2 = nums[len] * nums[len - 1] * nums[len - 2];
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        LC628 l = new LC628();
        int[] nums = new int[]{0, 1, 2, 3};
        System.out.println(l.maximumProduct(nums));
    }
}
