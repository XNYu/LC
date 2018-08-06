package dp;

public class LC309 {
    int[] dp;
    public int maxProfit(int[] prices) {
        int len = prices.length;
        dp = new int[len];
        int min =prices[0];
        int minmin=min;
        int minPos = 0;
        for(int i=1;i<len;i++){
            int price = prices[i];
            if(price<minmin)
                minmin=price;
            int profit=0;
            if(price<=prices[i-1]) {
                min = price;
                minPos = i;
                dp[i] = profit + get(minPos-1);
            }
            else{
                profit = price - min;
                int cur = profit + get(minPos-2);
                dp[i] = Math.max(cur , price - minmin);
            }

            System.out.println(i+","+minPos);
            print();
        }
        return dp[len - 1];
    }

    public void print() {
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }

    public int get(int i){
        if(i<0)
            return 0;
        else
            return dp[i];
    }

    public static void main(String[] args) {
        LC309 l = new LC309();
        System.out.println(l.maxProfit(new int[] {6,1,3,2,4,0,7}));
    }

}
