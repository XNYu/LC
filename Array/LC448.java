package Array;

import java.util.ArrayList;
import java.util.List;

public class LC448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int saved = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < nums.length) {
            int cur = nums[i];
            saved = i;
            while (cur != nums[cur-1]) {
                int tmp = nums[cur-1];
                nums[cur-1] = cur;
                cur = tmp;
            }
            i = saved;
            i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1)
                ans.add(j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC448 l = new LC448();
        System.out.println(l.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
