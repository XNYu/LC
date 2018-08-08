package Array;

public class LC189 {
    public void rotate(int[] nums, int k) {
        k++;
        if(k>=nums.length)
            k %= nums.length;
        int[] cpy = new int[k];
        System.arraycopy(nums, 0, cpy, 0, k);
        System.arraycopy(nums, k, nums, 0, nums.length - k);
        System.arraycopy(cpy, 0, nums, nums.length - k, k);
    }
}
