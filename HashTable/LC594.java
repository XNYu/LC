package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class LC594 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<1)
            return 0;
        int max = 0;
        int pre = nums[0];
        int preCount = 1;
        int i = 1;
        while (i<nums.length&&nums[i] == pre) {
            preCount++;
            i++;
        }
        while (i < nums.length) {
            int cur = nums[i];
            int curCount = 0;
            if (cur - pre == 1) {
                while (i<nums.length&&cur == nums[i]) {
                    curCount++;
                    i++;
                }
                max = Math.max(curCount + preCount, max);
            }
            else
            {
                while (i<nums.length&&cur == nums[i]) {
                    curCount++;
                    i++;
                }
            }
            pre = cur;
            preCount = curCount;
        }
        return max;
    }

    public int findLHS2(int[] nums) {
        if(nums.length==0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        TreeSet<Integer> set = new TreeSet<>(map.keySet());
        int pre = set.pollFirst();
        int countPre = map.get(pre);
        int max = 0;
        while (!set.isEmpty()) {
            int cur = set.pollFirst();
            System.out.println(cur);
            int countCur= map.get(cur);
            if (cur - pre <= 1 && cur - pre >= -1) {
                max = Math.max(countCur + countPre, max);
            }
            pre = cur;
            countPre = countCur;
        }
        return max;
    }

    public static void main(String[] args) {
        LC594 l = new LC594();
        int[] nums = new int[]{1,2,2,2,3,3,3,3,3,4,4,4,4,4,4,1};
        System.out.println(l.findLHS(nums));
    }
}
