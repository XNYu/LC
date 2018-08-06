package dp;

import java.util.Arrays;

public class LC64 {
    int[][] dp;
    int M, N;
    int[][] grid;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        int len = grid.length;
        int len1 = grid[0].length;
        dp = new int[len][len1];
        M = len;
        N = len1;
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return paths(0, 0);
    }

    public int paths(int m,int n) {
        if(m==M||n==N)
            return -1;
        if(dp[m][n]!=-1)
            return dp[m][n];
        int p1 = paths(m + 1, n);
        int p2 = paths(m, n + 1);
        int count = 0;
        if(p1>-1&&p2>-1)
            count = Math.min(p1, p2);
        else
            count = Math.max(0, Math.max(p1, p2));
        count += grid[m][n];
//        System.out.println(m+"_"+n+"     "+count);
        dp[m][n] = count;
        return count;
    }

    public static void main(String[] args) {
        LC64 l = new LC64();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(l.minPathSum(grid));
    }


}
