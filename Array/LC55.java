package Array;

public class LC55 {
    public boolean canJump(int[] nums) {
        if(nums[0]==0)
            return false;
        int max = 1;
        for (int i = 0; i < max; i++) {
            max = Math.max(max, nums[i] + i);
            if(max>=nums.length-1)
                return true;
        }
        if (max>=nums.length-1)
            return true;
        return false;
    }


    public static void main(String[] args) {
        LC55 l = new LC55();
        System.out.println(l.canJump(new int[]{3, 2, 2, 0, 4}));
    }
}
