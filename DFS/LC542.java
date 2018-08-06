package DFS;


import java.util.Arrays;
import java.util.LinkedList;

public class LC542 {
    int[][] dp;
    int len1,len2;
    int[][] matrix;
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }
        this.matrix = matrix;
        len1 = matrix.length;
        len2 = matrix[0].length;
        dp = new int[matrix.length][matrix[0].length];
        for (int[] d : dp) {Arrays.fill(d,Integer.MAX_VALUE);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0)
                    find1(i, j, 0);
            }
        }
        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = matrix[0].length-1; j >=0 ; j--) {
                if(matrix[i][j]==0)
                {
                    find2(i, j, 0);
                }
            }
        }
        return dp;
    }

    public void find1(int i, int j, int depth) {
        if(i<0||j<0||i>=len1||j>=len2)
            return;
        if (dp[i][j] > depth) {
            dp[i][j] = depth;
            depth++;
            find1(i + 1, j, depth);
            find1(i, j+1, depth);
        }
    }
    public void find2(int i, int j, int depth) {
        if(i<0||j<0||i>=len1||j>=len2)
            return;
        if (dp[i][j] >= depth) {
            dp[i][j] = depth;
            depth++;
            find2(i - 1, j, depth);
            find2(i, j-1, depth);
        }
    }

    public void print(int[][] dp) {
        for (int[] d : dp) {
            System.out.println();
            for (int i : d) {
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        LC542 l = new LC542();
        int[][] nums = new int[][]{
                {0,1,0,1,1},
                {1,1,0,0,1},
                {0,0,0,1,0},
                {1,0,1,1,1},
                {1,0,0,0,1}};
        l.print(l.updateMatrix(nums));
    }
}
