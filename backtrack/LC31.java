package backtrack;

import java.util.Arrays;

public class LC31 {
    public void nextPermutation(int[] nums) {
        boolean success = false;
        int len = nums.length;
        int size = 1;
        int[] cur = null;
        while (size < len) {
            cur = Arrays.copyOfRange(nums, len - size, len);
            int preNumber = nums[len - size - 1];
            System.out.println(preNumber+" "+cur.length);
            int preNum = Integer.MAX_VALUE;
            int changeI = 0;
            int curNum = 0;
            for (int i=0;i<cur.length;i++) {
                curNum = cur[i];
                if (preNumber < curNum && curNum < preNum) {
                    System.out.println(preNumber+"___"+curNum);
                    changeI = i;
                    preNum = curNum;
                    success = true;
                }
            }
            if(success)
            {
                nums[len - size - 1] = preNum;
                cur[changeI] = preNumber;
                Arrays.sort(cur);
                System.arraycopy(cur,0,nums,len-size,cur.length);
                break;
            }
            size++;
        }
        if (!success) {
            Arrays.sort(nums);
        }
    }

    public void print(int[] nums) {
        for (int n : nums) {
            System.out.print(n+",");
        }
    }

    public static void main(String[] args) {
        LC31 l = new LC31();
        int[] nums = new int[]{2,3,1};
        l.nextPermutation(nums);
        l.print(nums);
    }


}
