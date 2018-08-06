package dp;

import java.util.Arrays;

public class LC813 {
    double[][] dp;
    int[] nums;
    public double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        dp = new double[len][len];
        double[] dp2 = new double[len];
        nums = A;
        double max=0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                get(i, j);
            }
        }
        for (int i = 0; i < len; i++) {
            dp2[i] = get(0, i);
        }

        for (int i = 1; i < K; i++) {
            double[] dp3 = Arrays.copyOf(dp2,dp2.length);
            for (int j = 0; j < len; j++) {
                double maax = 0;
                for (int k = 0; k < j; k++) {
                    maax = Math.max(maax, dp3[k] + get(k + 1, j));
                }
                dp2[j] = maax;
            }
        }
        return dp2[len - 1];
    }

    public double get(int start, int end){
        if(dp[start][end]!=0)
            return dp[start][end];
        int total = 0;
        for (int i = start; i <= end; i++) {
            total+=nums[i];
        }
        double avg = (double) total/(end-start+1);
        dp[start][end] = avg;
        return avg;
    }

    public void print() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        LC813 l = new LC813();
        int[] nums = new int[]{9,1,2,3,9};
        int k = 4;
        System.out.println(l.largestSumOfAverages(nums, k));
        l.print();
    }
}
