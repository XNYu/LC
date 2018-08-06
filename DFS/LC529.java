package DFS;

public class LC529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        char c = board[click[0]][click[1]];
        if (c == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            trigger(click[0],click[1],board);
        }
        return board;
    }


    public int find(int x, int y, char[][] board) {
        if(board[x][y]=='M')
            return 1;
        return 0;
    }

    public void trigger(int x, int y, char[][] board) {
        int ans=0;
        char c = board[x][y];
        if(c!='E')
            return;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                ans += find(x + i, y + j, board);
            }
        }
        if (ans > 0) {
            board[x][y] = String.valueOf(ans).toCharArray()[0];
        } else {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    trigger(x + i, y + j, board);
                }
            }
            board[x][y] = 'B';
        }
    }
}
