package dp;

public class LC62 {
    int[][] dp;
    int M, N;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        M = m;
        N = n;
        dp[m-1][n-1] = 1;
        return paths(0, 0);
    }

    public int paths(int m,int n) {
        if(m==M||n==N)
            return 0;
        if(dp[m][n]!=0)
            return dp[m][n];

        int count = paths(m + 1, n) + paths(m, n + 1);
        dp[m][n] = count;
        return count;
    }

    public static void main(String[] args) {
        LC62 l = new LC62();
        System.out.println(l.uniquePaths(7,3));
    }




}
