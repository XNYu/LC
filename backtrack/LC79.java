package backtrack;

public class LC79 {
    public boolean exist(char[][] board, String word) {
        int len1 = board.length;
        if(len1==0)
            return false;
        int len2 = board[0].length;
        boolean[][] visited = new boolean[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                char c = board[i][j];
                if (c == word.charAt(0)) {
                    boolean curAns = back(board, word, 0, i, j,visited);
                    if (curAns)
                        return true;
                }
            }
        }
        return false;
    }

    int[][] to = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean back(char[][] board, String word, int position, int x, int y, boolean[][] visited) {
        if(x>board.length||x<0||y>board[0].length||y<0||position>=word.length()-1||visited[x][y]||board[x][y]!=word.charAt(position))
            return false;
        visited[x][y] = true;
        if(position==word.length()-1)
            return true;
        for (int[] too : to) {
            int curx = x + too[0];
            int cury = y + too[1];
            boolean curAns = back(board, word, position + 1, curx, cury, visited);
            if(curAns)
                return true;
        }
        visited[x][y] = false;
        return false;
    }
}
