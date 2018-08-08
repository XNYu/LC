package HashTable;

public class LC560 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < len; i++) {
            pre = nums[i];
            if(pre==k)
                ans++;
            for (int j = i+1; j < len; j++) {
                int cur = pre + nums[j];
                if (cur == k) {
                    ans++;
                }
                pre = cur;
            }
        }
        return ans;
    }


}
