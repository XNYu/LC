package Array;

public class LC45 {
    public int jump2(int[] nums) {
        if(nums.length==0||nums.length==1)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = 1; j <= cur && i+j<nums.length; j++) {
                times++;
                if(dp[i+j]==0)
                    dp[i + j] = dp[i] + 1;
                if(i+j==nums.length-1)
                {
                    System.out.println(times);
                    return dp[i + j];
                }
            }
        }
        return -1;
    }
    public int jump(int[] nums) {
        if(nums.length==0||nums.length==1)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        int max = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int limit = Math.min(nums.length -1 - i, cur);
            int j = 0;
            for (j = max +1 -i; j <= limit; j++) {
                times++;
                dp[i + j] = dp[i] + 1;
                if(i+j==nums.length-1)
                {
                    System.out.println(times);
                    return dp[i + j];
                }
            }
            max = i + j - 1;
        }
        System.out.println(times);
        return -1;
    }

    public void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LC45 l = new LC45();
        int[] nums = new int[]{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
        l.jump(nums);
        l.jump2(nums);
    }
}
