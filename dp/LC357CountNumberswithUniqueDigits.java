package dp;

public class LC357CountNumberswithUniqueDigits {
    int[] dp;
    int[] have;
    public int countNumbersWithUniqueDigits(int n){
        dp = new int[11];
        have = new int[n+1];
        have[1]=10;
        factorial(10);
        int ans = 0;
        for (int i = 1; i <=n ; i++) {
            ans += count(i);
        }
        return ans;
    }

    public int count(int n) {
        if(have[n]!=0)
            return have[n];
        int ans = getArr(10, n) - getArr(9, n - 1);
        have[n]=ans;
//        System.out.println(ans);
        return ans;
    }

    public int getArr(int all,int select){
        return getFact(all) / getFact(all - select);
    }
    public int getComb(int all,int select){
        return getFact(all) / (getFact(select) * getFact(all - select));
    }

    public int getFact(int n){
        return dp[n];
    }

    public void factorial(int n){
        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * i;
            dp[i] = ans;
        }
    }

    public static void main(String[] args) {
        LC357CountNumberswithUniqueDigits l = new LC357CountNumberswithUniqueDigits();
        System.out.println(l.countNumbersWithUniqueDigits(3));
    }
}
