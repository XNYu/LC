package Array;

public class LC832 {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A.length==0)
            return A;
        int len = A[0].length;
        for (int i = 0; i < A.length; i++) {
            int[] row = A[i];
            for (int j = 0; j <= (row.length-1)/2; j++) {
                System.out.println(j+","+(len-j-1));
                int tmp = row[j];
                row[j] = 1 ^ row[len - j - 1];
                row[len - j - 1] = 1 ^ tmp;
            }
            A[i] = row;
        }
        return A;
    }

    public static void main(String[] args) {
        LC832 l = new LC832();
        int[][] A = new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };
        l.flipAndInvertImage(A);
    }
}
