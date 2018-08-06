package dp;

public class LC343 {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n + 1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        return max(n);
    }

    public int max(int n) {
        int max=0;
        if(dp[n]!=0)
            return dp[n];
        for (int i = 1; i <= n/2; i++) {
            if(n==10)
                System.out.println(i);
            int cur = i*max(n-i);
            if(max<cur)
            {
                System.out.println(n+","+i+":"+cur);
            }
            max = Math.max(max, cur);
        }
        max = Math.max(max, n);
        dp[n] = max;
        return max;
    }

    public static void main(String[] args) {
        LC343 l = new LC343();
        System.out.println(l.integerBreak(3));
    }
}
