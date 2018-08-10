package Array;

public class LC59 {
    boolean[][] visited;
    int[][] ans;
    public int[][] generateMatrix(int n) {
        int pos = 1;
        int layer = 0;
        visited = new boolean[n][n];
        ans = new int[n][n];
        int i, j;
        while (layer <= n / 2) {
            for (i = layer; i < n-layer; i++) {
                insert(layer, i, pos);
                pos++;
            }
            for (j = layer; j < n-layer; j++) {
                insert(j, i-1, pos);
                pos++;
            }
            for (i = n - layer-1; i >= layer; i--) {
                insert(j-1, i, pos);
                pos++;
            }
            for (j = n - layer-1; j > layer; j--) {
                insert(j, i+1, pos);
                pos++;
            }
            layer++;
        }
        return ans;
    }

    public void insert(int x, int y, int pos) {
        if(!visited[x][y])
        {
            System.out.println(x+","+y);
            ans[x][y] = pos;
            visited[x][y] = true;
        }
    }

    public static void main(String[] args) {
        LC59 l = new LC59();
        System.out.println(l.generateMatrix(3));
    }
}
