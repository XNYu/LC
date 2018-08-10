package Array;

public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int len = matrix[0].length;
        for (int[] nums : matrix) {
            if(nums[0]<=target&&nums[len-1]>=target)
                return binary(nums, 0, len - 1, target);
        }
        return false;
    }

    public boolean binary(int[] nums, int s, int e, int target) {
        int mid = e + s / 2;
        if (e - s < 2) {
            if(nums[e]==target||nums[s]==target)
                return true;
            return false;
        }
        if(nums[mid]==target)
            return true;
        if (nums[mid] < target) {
            return binary(nums, s, mid, target);
        }
        return binary(nums, mid+1, e, target);
    }
}
