package Array;

import java.util.Arrays;

public class LC215 {
    Helper h = new Helper();
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
       int ans = findKth(nums,0,nums.length-1,k);
       return nums[ans];
    }

    public int findKth(int[] nums, int start, int end, int target) {
        int pivot = start;
        for (int i = pivot+1; i <= end; i++) {
            if (nums[i] > nums[pivot]) {
                pivot = swap(nums, pivot, i);
            }
        }
        if (pivot == target-1) {
            return pivot;
        } else {
            if (pivot < target-1) {
                return findKth(nums, pivot+1, end,target);
            }
            else
                return findKth(nums, start, pivot-1,target);
        }
    }

    public int swap(int[] nums,int pivot,int more) {
        int tmp = nums[pivot + 1];
        if (more - pivot == 1) {
            nums[more] = nums[pivot];
            nums[pivot] = tmp;
            return pivot + 1;
        }
        nums[pivot + 1] = nums[pivot];
        nums[pivot] = nums[more];
        nums[more] = tmp;
        return pivot + 1;
    }

    public static void main(String[] args) {
        LC215 l = new LC215();
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(l.findKthLargest(nums,4));
    }
}
