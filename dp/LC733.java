package dp;

public class LC733 {
    int row, col;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        row = image.length;
        if (row < 1||image[sr][sc]==newColor) {
            return image;
        }
        col = image[0].length;
        flood(image, sr, sc, image[sr][sc],newColor);
        return image;
    }

    int[][] addUps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void flood(int[][] image, int x, int y, int from, int to) {
        if(!valid(x,y,from,image))
            return;
        int curColor = image[x][y];
        if (curColor == to) {
            return;
        } else {
            image[x][y] = to;
            for (int[] add : addUps) {
                flood(image, x + add[0], y + add[1],from, to);
            }
        }
    }

    public boolean valid(int x, int y, int color, int[][] image) {
        if (x < 0 || y < 0 || x >= row || y >= col||(image[x][y]!=color)) {
            return false;
        }
        return true;
    }
}
