package dp;

import java.util.Arrays;

public class LC494 {
    int[][] dp;
    int[] nums;
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        this.nums = nums;
        dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = find(0, S);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j][i]+" ");
            }
            System.out.println();
        }
        return ans;
    }

    public int find(int start, int S) {
        int curPos = nums[start];
        int pos, neg;
        System.out.println(S+","+start+","+curPos);
        if(start==nums.length-1){
            if(S==curPos||S==-curPos)
                return 1;
            return 0;
        }
//        if (dp[start][0] != -1) {
//            pos = dp[start][0];
//        } else {
            pos = find(start + 1, S - curPos);
//        }
        dp[start][0] = pos;
//        if (dp[start][1] != -1) {
//            neg = dp[start][1];
//        } else {
            neg = find(start + 1, S + curPos);
//        }
        dp[start][1] = neg;
        return pos + neg;
    }

    public static void   main(String[] args) {
        LC494 l = new LC494();
        int[] nums = new int[]{1,1};
        System.out.println(l.findTargetSumWays(nums,1));
    }
}
