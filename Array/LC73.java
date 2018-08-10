package Array;

public class LC73 {
    Helper h = new Helper();
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        boolean row = false, col = false;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                }
            }
            h.print(matrix);
        for (int i = 1; i < m; i++){
            if (matrix[i][0] == 0){
                for (int j = 1; j < n;j++)
                    matrix[i][j] = 0;
            }
        }
        h.print(matrix);
        for (int j = 1; j < n; j++){
            if (matrix[0][j] == 0){
                for (int i = 1; i < m; i++)
                    matrix[i][j] = 0;
            }
        }
        h.print(matrix);
        if (row){
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }
        h.print(matrix);
        if (col){
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
        h.print(matrix);
    }

    public void setZeroes2(int[][] matrix) {
        int len1 = matrix.length;
        if(len1==0)
            return;
        int len2 = matrix[0].length;
        boolean[] verZeros = new boolean[matrix.length];
        boolean[] horZeros = new boolean[matrix[0].length];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int cur = matrix[i][j];
                if (cur == 0) {
                    horZeros[j] = true;
                    verZeros[i] = true;
                }
            }
        }
        for (int i = 0; i < verZeros.length; i++) {
            if(!verZeros[i])
                continue;
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j = 0; j < horZeros.length; j++) {
            if(!horZeros[j])
                continue;
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    public boolean isNewZero(int i, int j, int[][] matrix) {
        int horizon = 0, vertical = 0;
        for (int k = 0; k < matrix.length; k++) {
            horizon = horizon | matrix[k][j];
        }
        for (int k = 0; k < matrix[0].length; k++) {
            vertical = vertical | matrix[i][k];
        }
        int ans = horizon & vertical;
        return ans == 0;
    }

    public void insertHorizon(int i, int j, int[][] matrix){
        for (int k = i+1; k < matrix.length; k++) {
            if (matrix[k][j] != 0) {
                matrix[k][j] = 0;
            } else {
                insertVertical(k, j, matrix);
            }
        }
        for (int k = i-1; k >=0 ; k--) {
            if (matrix[k][j] != 0) {
                matrix[k][j] = 0;
            } else {
                insertVertical(k, j, matrix);
            }
        }
    }
    public void insertVertical(int i, int j, int[][] matrix) {
        for (int k = j+1; k < matrix[0].length; k++) {
            if (matrix[i][k] != 0) {
                matrix[i][k] = 0;
            } else {
                insertHorizon(i,k,matrix);
            }
        }
        for (int k = j-1; k >=0; k--) {
            if (matrix[i][k] != 0) {
                matrix[i][k] = 0;
            } else {
                insertHorizon(i,k,matrix);
            }
        }
    }


    public static void main(String[] args) {
        LC73 l = new LC73();
        int[][] nums = new int[][]{
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1,}
        };
        nums = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1}
        };
        l.setZeroes(nums);
    }
}
