package Array;

public class LC16 {
    public int threeSumClosest(int[] nums, int target) {
        int min=Integer.MAX_VALUE, sum=0;
        int[] sums = new int[nums.length+1];
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        for (int i = 3; i < sums.length; i++) {
            int minus = sums[i] - sums[i - 3];
            int abs = Math.abs(minus - target);
            if (abs < min) {
                min = abs;
                sum = minus;
            }
        }
        return sum;
    }
}
