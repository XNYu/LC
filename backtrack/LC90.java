package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                begin = 0;
            }
            int size = ans.size();
            for (int j = begin; j < ans.size(); j++) {
                ArrayList<Integer> tmp = (ArrayList<Integer>) ans.get(j);
                tmp.add(nums[i]);
                ans.add(tmp);
            }
            begin = size;
        }
        return ans;
    }



    public static void main(String[] args) {
        LC90 l = new LC90();
        int[] nums = new int[]{5, 5, 5, 5, 5, 6};
        char c = 65;
        System.out.println(Integer.valueOf('Z'));
        System.out.println(Integer.valueOf('a')+" "+Integer.valueOf('A'));
    }
}
