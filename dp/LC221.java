package dp;

import java.util.Arrays;

public class LC221 {
    int[][] dp;
    char[][] m;
    public int maximalSquare(char[][] matrix) {
        int lenx = matrix.length;
        if(lenx==0)
            return 0;
        int leny = matrix[0].length;
        m = matrix;
        dp = new int[lenx][leny];
        int max = 0;
        for (int i = 0; i <lenx; i++) {
            for (int j = 0; j < leny; j++) {
                if(matrix[i][j]=='1')
                {
                    dp[i][j] = find(i, j);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }

    public int find(int x,int y) {
        int a=0,b=0,c=0;
        if(x!=0)
            a = dp[x - 1][y];
        if(y!=0)
            b = dp[x][y - 1];
        if(x!=0&&y!=0)
            c = dp[x-1][y-1];
        return Math.min(Math.min(a,b),c)+1;

    }

    public static void main(String[] args) {
        LC221 l = new LC221();
        char[][] nums = new char[][]{{'1','1','1','0','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(l.maximalSquare(nums));
    }
}
