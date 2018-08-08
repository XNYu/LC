package Array;

public class LC287 {
    public int findDuplicate(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int pre = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]==pre)
                    return pre;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC287 l = new LC287();
        int[] nums = new int[]{1,3,4,3,2};
        System.out.println(l.findDuplicate(nums));
    }
}
