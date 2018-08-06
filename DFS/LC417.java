package DFS;

import java.util.LinkedList;
import java.util.List;

public class LC417 {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new LinkedList<>();
        int row = matrix.length;
        if (row < 1) {
            return ans;
        }
        int col = matrix[0].length;
        boolean[][] Pac = new boolean[row][col];
        boolean[][] Atl = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    Pac[i][j] = true;
                }
                if (Pac[i][j])
                    put(i, j, Pac, matrix);
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 || j == col - 1) {
                    Atl[i][j] = true;
                }
                if(Atl[i][j])
                    put(i,j,Atl,matrix);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(Atl[i][j]&&Pac[i][j])
                    ans.add(new int[]{i, j});
            }
        }
        return ans;
    }

    public void put(int i, int j, boolean[][] booleans,int[][] matrix) {
        int val = matrix[i][j];
        int[][] todo = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] to : todo) {
            int curi = i + to[0];
            int curj = j + to[1];
            if(curi<0||curj<0||curi>=booleans.length||curj>=booleans[0].length||booleans[curi][curj]||val>matrix[curi][curj])
                continue;
            booleans[curi][curj] = true;
            put(curi, curj, booleans, matrix);
        }
    }

    public void print(boolean[][] booleans) {
        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[0].length; j++) {
                System.out.print(" " + (booleans[i][j] ? 1 : 0));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        LC417 l = new LC417();
        int[][] sea = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4},
        };
        sea = new int[][]{
                {1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}
        };
//        sea = new int[][]{
//                {1,2,3},
//                {8,9,4},
//                {7,6,5}
//        };
        for (int[] ans : l.pacificAtlantic(sea)) {
            System.out.println(ans[0]+","+ans[1]);
        }
    }
}
