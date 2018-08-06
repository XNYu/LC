package dp;

public class LC486 {
//    public boolean PredictTheWinner(int[] nums){
//
//    }
    int[][] dp1,dp2;
    public boolean PredictTheWinner(int[] nums) {
        dp1 = new int[nums.length][nums.length];
        dp2 = new int[nums.length][nums.length];
        if(nums.length<3)
            return true;
        return predict(nums[0], 0, 1, nums.length - 1, nums, false) ||
                predict(nums[nums.length-1], 0, 0, nums.length - 2, nums, false) ;
    }

    public boolean predict(int one,int two,int start, int end, int[] nums, boolean first){
        if (first) {
            if (dp1[start][end] != 0) {
                return dp1[start][end]==1;
            }
        }
        else {
            if (dp2[start][end] != 0) {
                return dp2[start][end]==1;
            }
        }
        if(start==end){
        if (first)
            one += nums[start];
        else
            two += nums[start];
        if (one>=two)
            return true;
        else
            return false;
        }
        if (first) {
            System.out.println(one+","+two+"  "+start+","+end);
            boolean ans = predict(one + nums[start], two, start + 1, end, nums, !first) ||
                    predict(one + nums[end],two,start,end-1,nums,!first);
            dp1[start][end] = ans?1:0;
            return ans;
        }
        else
        {
            System.out.println("Second "+one+","+two+"  "+start+","+end);
            boolean ans = predict(one , two + nums[start], start + 1, end, nums, !first) &&
                    predict(one,two + nums[end],start,end-1,nums,!first);
            dp2[start][end] = ans?1:0;
            return ans;
        }
    }

    public static void main(String[] args) {
        LC486 l = new LC486();
        int[] nums = new int[]{1,1};
        System.out.println(l.PredictTheWinner(nums));
    }
}
