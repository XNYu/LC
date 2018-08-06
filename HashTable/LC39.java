package HashTable;

import java.util.HashSet;

public class LC39 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if(c<'1'||c>'9')
                    continue;
                String x = c + "x" + i;
                String y = c + "y" + j;
                String z = c + "in" + i + "" + j;
                if (!set.add(x) || !set.add(y) || !set.add(z)) {
                    return false;
                }
            }
        }
        return true;
    }
}
