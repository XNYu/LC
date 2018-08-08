package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums==null||nums.length==0)
            return ans;
        //voting algorithm
        int n1 = nums[0], n2 = nums[0], c1 = 0, c2 = 0;
        for (int i : nums) {
            if (i == n1) {
                c1++;
            } else if (i == n2) {
                c2++;
            } else if (c1 == 0) {
                n1 = i;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = i;
                c2 = 1;
            }
            c1--;
            c2--;
        }
        c1 = c2 = 0;
        for (int i : nums) {
            if(i==n1)
                c1++;
            else if(i==n2)
                c2++;
        }
        if (c1 > nums.length / 3) {
            ans.add(n1);
        }
        if (c2 > nums.length / 2) {
            ans.add(n2);
        }
        return ans;
    }
    public List<Integer> majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int limit = nums.length / 3;
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry e : map.entrySet()) {
            if ((int) e.getValue() > limit) {
                ans.add((int) e.getKey());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
