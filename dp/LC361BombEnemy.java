package dp;

public class LC361BombEnemy {

    public static void main(String[] args) {
        LC361BombEnemy l = new LC361BombEnemy();
        char[][] grid = {{'W'},{'E'},{'W'},{'0'},{'E'}};
        System.out.println(l.maxKilledEnemies(grid));
    }

    public int maxKilledEnemies(char[][] grid) {

        int li = grid.length;
        if(li==0)
            return 0;
        int wi = grid[0].length;
        int[][] horizon = new int[li][wi];
        int[][] vector = new int[li][wi];
        int max = 0;
        for(int i=0;i<li;i++)
            for(int j=0;j<wi;j++){
                char cur = get(grid, i, j);
                if(cur=='W'||cur=='E')
                    continue;

                int bi = i-1;
                int bj = j-1;

                char up = get(grid, i, bj);
                char left = get(grid, bi, j);

                boolean wall = false;
                while(up!='0'){
                    if(up=='W'){
                        wall = true;
                        vector[i][j] = explode(grid, false, i, j);
                        break;
                    }
                    bj--;
                    up = get(grid, i, bj);
                }
                if(!wall)
                    vector[i][j] = vector[i][bj];
                wall = false;

                while (left!='0'){
                    if(left=='W')
                    {
                        wall = true;
                        horizon[i][j] = explode(grid, true, i, j);
                        break;
                    }
                    bi--;
                    left = get(grid, bi, j);
                }
                if(!wall)
                    horizon[i][j] = horizon[bi][j];

//                if(up=='W')
//                    vector[i][j] = explode(grid, false, i, j);
//                else if(up=='E'){
//                    boolean wall = false;
//                    while (true){
//                    bj--;
//                    up = get(grid,i,bj);
//                    if(up=='W'){
//                        wall = true;
//                        break;
//                        }
//                        if (up=='E')
//                    }
//                    if(wall)
//                        vector[i][j] = explode(grid, false, i, j);
//                }
//                else
//                    vector[i][j] = vector[i][bj];
//                if(left=='W')
//                    horizon[i][j] = explode(grid, true, i, j);
//                else
//                    horizon[i][j] = horizon[bi][j];

                int total = vector[i][j]+horizon[i][j];
                max=max>total?max:total;
            }
        return max;
    }

    public char get(char[][] grid,int i,int j){
        if(i>-1&&j>-1&&i<grid.length&&j<grid[0].length){
            return grid[i][j];
        }
        else {
            return 'W';
        }

    }

    public int explode(char[][] grid, boolean horizon, int hor, int vec){
        int total=0;
        boolean aroundUp = false;
        boolean aroundLeft = false;
        if(horizon){
            boolean end = false;
            int increase = -1;
            int i = hor;
            boolean up = true;
            while(!end){
                i += increase;
                char cur = get(grid,i,vec);
                System.out.println(i);
                System.out.println(cur);
                if(cur=='W'){
                    if (up) {
                        increase = 1;
                        up = false;
                        i=hor;
                    }
                    else
                        end=true;
                }
                if(cur=='E')
                    total+=1;

            }
        }
        else{
            boolean end = false;
            int increase = -1;
            int j = vec;
            boolean left = true;
            while(!end){
                j += increase;
                char cur = get(grid, hor, j);
                if(cur=='W'){
                    if (left)
                    {increase=1;left=false;j=vec;}
                    else
                        end=true;
                }
                if(cur=='E')
                    total+=1;

            }
        }
        return total;
    }
}