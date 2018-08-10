package Array;

public class LC34 {
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0)
            return new int[]{-1, -1};
        binary(nums, 0, nums.length - 1, target);
        if(min==Integer.MAX_VALUE)
            min = -1;
        if(max == Integer.MIN_VALUE)
            max = -1;
        return new int[]{min, max};
    }

    public void binary(int[] nums, int s, int e, int target) {
        int mid = (e + s) / 2;
        if(s>e)
            return;
        if (e==s) {
            if (nums[s] == target) {
                max = Math.max(s, max);
                min = Math.min(s, min);
            }
            return;
        }
        if (nums[mid] == target) {
            max = Math.max(mid, max);
            min = Math.min(mid, min);
            binary(nums, mid + 1, e, target);
            binary(nums, s, mid - 1, target);
            return;
        } else if (nums[mid] < target) {
            binary(nums, mid + 1, e, target);
        } else {
            binary(nums, s, mid, target);
        }
    }
}
