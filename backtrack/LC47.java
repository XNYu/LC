package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(ret,new ArrayList<>(),nums,new boolean[nums.length]);
        return ret;
    }

    public void backtracking(List<List<Integer>> ret,List<Integer> list,int[] nums,boolean[] used) {
        if(list.size()==nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            backtracking(ret,list,nums,used);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        LC47 l = new LC47();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(l.permuteUnique(nums));
    }
}
