package Array;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        return binary(nums, 0, nums.length - 1, target);
    }

    public int binary(int[] nums, int s, int e, int target) {
        int mid = (s + e) / 2;
        if (e - s < 2) {
            if(nums[s]>=target)
                return s;
            if(nums[e]>=target)
                return e;
        }
        if(nums[mid]==target)
            return mid;
        if(nums[mid]>target)
            return binary(nums, s, mid, target);
        else return binary(nums, mid + 1, e, target);
    }
}
