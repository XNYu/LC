package Array;

public class LC566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int len1 = nums.length;
        if(len1==0)
            return nums;
        int len2 = nums[0].length;
        if (len1*len2!=r*c) {
            return nums;
        }
        int row = 0, col = 0;
        int[][] ans = new int[r][c];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                ans[row][col] = nums[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return ans;
    }
}
