package dp;

import java.util.Arrays;

public class LC63 {
    int[][] dp;
    int M, N;
    int[][] grid;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid = obstacleGrid;
        int len = grid.length;
        int len1 = grid[0].length;
        dp = new int[len][len1];
        M = len;
        N = len1;
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[M - 1][N - 1] = grid[M-1][N-1]==0?1:0;
        int count = paths(0, 0);
        return Math.max(0, count);
    }

    public int paths(int m,int n) {
        if(m==M||n==N)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        if(grid[m][n]==1)
        {
            dp[m][n] = -2;
            return -2;
        }
        int p1 = paths(m + 1, n);
        int p2 = paths(m, n + 1);
        int count = p1 + p2;
        if(p1==-2)
            count+=2;
        if(p2==-2)
            count+=2;
        dp[m][n] = count;
        return count;
    }

    public static void main(String[] args) {
        LC63 l = new LC63();
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(l.uniquePathsWithObstacles(grid));
    }
}
