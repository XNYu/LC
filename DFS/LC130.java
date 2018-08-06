package DFS;

public class LC130 {
    int len,wid;
    boolean[][] dp;

    public void solve(char[][] board) {
        len = board.length;
        wid = board[0].length;
        dp = new boolean[len][wid];
        for (int i = 0; i < len; i++) {
            tag(i,0,board);
            tag(i,wid-1,board);
        }
        for (int j = 0; j < wid; j++) {
            tag(0, j, board);
            tag(len - 1, j, board);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                if(onBorder(i, j))
                    continue;
                if(!dp[i][j])
                    board[i][j] = 'X';
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                System.out.print(" " + (board[i][j]));
            }
            System.out.println();
        }
    }
    public boolean getdp(int i,int j) {
        if(i<0||j<0||i>=len||j>=wid)
            return true;
        return dp[i][j];
    }

    public void tag(int i,int j, char[][] board) {
        if (getdp(i, j)) {
            return;
        }
        char c = get(i, j, board);
        if(c=='O'){
            dp[i][j] = true;
            tag(i + 1, j, board);
            tag(i - 1, j, board);
            tag(i, j + 1, board);
            tag(i, j - 1, board);
        }
    }

    public char get(int i,int j,char[][] board) {
        if(i<0||j<0||i>=len||j>=wid)
            return 'X';
        return board[i][j];
    }

    public boolean onBorder(int x, int y) {
        if (x == 0 || y == 0 || x == len - 1 || y == wid - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC130 l = new LC130();
        char[][] chars = new char[][]{
                {'O'}};
        l.solve(chars);
    }

}
