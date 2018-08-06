package dp;

import java.util.HashMap;

public class LC523ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int len = nums.length;
        if(len<2)
            return false;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            cur = cur + nums[i];
            if(k!=0)
                cur = cur%k;
            System.out.println(cur);
            if(map.containsKey(cur))
            {
                int prev = map.get(cur);
                if(i-prev>1)
                    return true;
            }
            else
                map.put(cur,i);
        }
//        print(dp);
        return false;
    }

    public void print(int[] dp) {
        int len = dp.length;
        for (int i = 0; i < len; i++) {
            System.out.print(dp[i]+" ");
        }
            System.out.println();
    }

    public static void main(String[] args) {
        LC523ContinuousSubarraySum l = new LC523ContinuousSubarraySum();
        long cur = System.nanoTime();
        int[] nums = new int[]{0,0};
        System.out.println(l.checkSubarraySum(nums,0));
        System.out.println(System.nanoTime()-cur);

    }
}
