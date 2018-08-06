package dp;

public class LC300 {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        dp = new int[len];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            for (int j = 0; j < i; j++) {
                int pre = nums[j];
                if (i > j) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                System.out.println(i);
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            System.out.println(i+","+tails[i]);
            if (i == size) ++size;
        }
        return size;
    }

    public static void main(String[] args) {
        LC300 l = new LC300();
        int[] nums = new int[]{1,6,7,2};
        l.lengthOfLIS2(nums);
    }
}
