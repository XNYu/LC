package Array;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int layer = 0;
        int hor = matrix.length;
        int vet = matrix[0].length;
        boolean[][] visited = new boolean[hor][vet];
        while (layer <= Math.min(matrix.length,matrix[0].length) / 2) {
            int i, j;
            for (i = layer; i < vet-layer; i++) {
                if(!visited[layer][i])
                ans.add(matrix[layer][i]);
                visited[layer][i] = true;
            }
            for (j = layer+1; j < hor-layer; j++) {
                if(!visited[j][i-1])
                ans.add(matrix[j][i-1]);
                visited[j][i - 1] = true;
            }
            for (i = vet-layer-2; i >= layer ; i--) {
                if(!visited[j-1][i])
                ans.add(matrix[j-1][i]);
                visited[j - 1][i] = true;
            }
            for (j = hor-layer-2; j > layer ; j--) {
                if(!visited[j][i+1])
                ans.add(matrix[j][i+1]);
                visited[j][i + 1] = true;
            }
            layer++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LC54 l = new LC54();
        int[][] nums = new int[][]{
                {1},
                {2},
                {3}
        };
        System.out.println(l.spiralOrder(nums));

    }
}
