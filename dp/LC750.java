package dp;

public class LC750 {
    int height,width;
    int[][] horizon,vertical;
    public int countCornerRectangles(int[][] grid) {
        height = grid.length;
        width = grid[0].length;
        horizon = new int[height][width];
        vertical = new int[height][width];

        int ans =0;
        int curi=0;
        int curj=0;
        for (int i = 0; i < height; i++) {
            curi=i;
            for (int j = 0; j < width; j++) {
                curj=j;
                if(grid[i][j]==1) {
                    vertical[curi][curj] = i - curi;
                    horizon[curi][curj] = j - curj;
                }
            }
        }
        curi=0;
        curj=0;
        while (curi<height&&curj<width){

        }
        return ans;
    }
    public int find(int[][] grid,int i,int j){
        int ans = 0;
        int orii = i;
        int orij = j;
        int curi = i;
        int curj = j;

        return ans;
    }

}
