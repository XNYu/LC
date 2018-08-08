package Array;

public class LC153 {
    int min = Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        binary(nums,0,nums.length-1);
        return min;
    }

    public void binary(int[] nums, int s, int e) {
        System.out.println(s+","+e);
        int mid = (e + s) / 2;
        if (e - s < 2) {
            min = Math.min(Math.min(nums[e], nums[s]), min);
            return;
        }
        if (nums[e] > nums[s]) {
            min = Math.min(min, nums[s]);
        }
        binary(nums, s, mid);
        binary(nums, mid + 1, e);
    }

    public static void main(String[] args) {
        LC153 l = new LC153();
        int[] nums = new int[]{4, 5, 6, 7, 1, 2, 3};
        System.out.println(l.findMin(nums));
    }
}
