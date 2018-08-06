package dp;

import java.util.Arrays;

public class LC322COINCHANGE {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for(int coin:coins){
                if(i-coin>=0&&dp[i-coin]!=-1)
                {
                    min = Math.min(min,dp[i-coin]+1);
                    System.out.println(min);
                }
            }
            if(min==Integer.MAX_VALUE)
                dp[i] = -1;
            else
                dp[i] = min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        LC322COINCHANGE l = new LC322COINCHANGE();
        int[] coins = new int[]{1,2,5};
        System.out.println(l.coinChange(coins,11));
    }
}
