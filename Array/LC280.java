package Array;

public class LC280 {
    Helper h = new Helper();
    public void wiggleSort(int[] nums) {
        if(nums.length==0||nums.length==1)
            return;
        findKth(nums, 0, nums.length - 1,nums.length/2);
        h.print(nums);
        int len = nums.length;
        int mid = nums.length / 2;
        if(len%2==1)
            mid += 1;
        System.out.println(mid);
        for (int i = 1; i < mid; i+=2) {
            int tmp = nums[i];
            nums[i] = nums[i + mid];
            nums[i + mid] = tmp;
        }
    }

    public int findKth(int[] nums, int start, int end, int target) {
        int pivot = start;
        for (int i = pivot+1; i <= end; i++) {
            if (nums[i] < nums[pivot]) {
                pivot = swap(nums, pivot, i);
            }
        }
        int mid = nums.length / 2;
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

    public int swap(int[] nums,int pivot,int less) {
        int tmp = nums[pivot + 1];
        nums[pivot + 1] = nums[pivot];
        nums[pivot] = nums[less];
        nums[less] = tmp;
        return pivot + 1;
    }

    public static void main(String[] args) {
        LC280 l = new LC280();
        l.wiggleSort(new int[]{0,1,2});
    }
}
