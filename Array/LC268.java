package Array;

public class LC268 {
    public int missingNumber(int[] nums) {
        int i = 0;
        int saved = 0;
        while (i < nums.length) {
            int cur = nums[i];
            if(cur==nums.length)
            {
                i++;
                continue;
            }
            saved = i;
            while (cur != nums[cur]) {
                int tmp = nums[cur];
                nums[cur] = cur;
                cur = tmp;
                if(cur==nums.length)
                    break;
            }
            i = saved;
            i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=j)
                return j;
        }
        return nums.length;
    }

    public void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LC268 l = new LC268();
        int[] nums = new int[]{8,7,6,5,4,3,1,2};
        System.out.println(l.missingNumber(nums));
    }
}
