package Array;

public class LC48 {
    int len,layer;
    public void rotate(int[][] matrix) {
        len = matrix.length;
        System.out.println(len);
        layer = 0;
        while (layer < len - 2) {
            for (int i = layer; i < len-layer-1; i++) {
                int[] des = new int[]{layer, i};
                int destVal = matrix[des[0]][des[1]];
                for (int j = 0; j < 4; j++) {
                    des = dest(des[0], des[1], matrix);
                    int backUp = matrix[des[0]][des[1]];
                    matrix[des[0]][des[1]] = destVal;
                    destVal = backUp;
                }
            }
            layer++;
        }
    }

    public int[] dest(int i, int j,int[][] matrix) {
        int len = matrix.length;
        int x = j;
        int y = len - i - 1;
//        System.out.println(i+","+j+"→"+x+","+y);
        return new int[]{x, y};
    }

    public void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LC48 l = new LC48();
        int[][] nums = new int[][]{
                {1, 2}, {3, 4}
        };
        l.rotate(nums);
        l.print(nums);
    }
}
