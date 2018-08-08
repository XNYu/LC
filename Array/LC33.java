package Array;

public class LC33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len==0)
            return -1;
        return binary(nums, 0, len-1, target);
    }

    public int binary(int[] nums, int s, int e, int target) {
        int len = e+s;
        System.out.println(s+","+e);
        if (e-s<2)
        {
            if (nums[s]==target)
                return s;
            if(nums[e]==target)
                return e;
            return -1;
        }
        if (nums[s] < nums[len / 2]) {
            if (target >= nums[s] && target <= nums[len / 2])
                return binary(nums, s, len / 2, target);
            return binary(nums, len / 2 + 1, e, target);
        } else {
            if (target >= nums[len / 2 + 1] && target <= nums[e]) {
                return binary(nums, len / 2 + 1, e, target);
            }
            return binary(nums, s, len / 2, target);
        }
    }

    public int nonB(int[] nums, int s, int e, int target) {
        int len = e+s;
        System.out.println(s+","+e);
        if (e-s<2)
        {
            if (nums[s]==target)
                return s;
            if(nums[e]==target)
                return e;
            return -1;
        }
        if (nums[s] < nums[len / 2]) {
            System.out.println(s+","+len/2);
            if (target >= nums[s] && target <= nums[len / 2])
                return binary(nums, s, len / 2, target);
            return nonB(nums, len / 2 + 1, e, target);
        } else {
            if (target >= nums[len / 2 + 1] && target <= nums[e]) {
                return binary(nums, len / 2 + 1, e, target);
            }
            return nonB(nums, s, len / 2, target);
        }
    }

    public static void main(String[] args) {
        LC33 l = new LC33();
        int[] nums = new int[]{1111111,1111112,1111113,1111114,1,2,3,4,5,6,7,8,9,10,11,111,1111,11111};
        System.out.println(l.search(nums,11111));
    }
}
