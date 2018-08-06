package HashTable;

public class LC311 {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] ans = new int[A.length][B[0].length];
        int len = A[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                int a = 0;
                for (int k = 0; k < len; k++) {
                    a += A[i][k] * B[k][j];
                }
                ans[i][j] = a;
            }
        }
        return ans;
    }
}
