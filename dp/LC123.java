package dp;

public class LC123 {
    int[] buy,sell;
    public int maxProfit(int[] prices) {
        int len = prices.length;
        buy = new int[len];
        sell = new int[len];
        buy[0] = -prices[0];
        sell[0] = 0;
        boolean bought=true;
        for (int i = 1; i < len; i++) {
            int buypre = buy[i-1];
            int sellpre = sell[i-1];
            int price = prices[i];
            if (bought) {
                buy[i] = Math.max(buypre,sellpre-price);
                sell[i] = Math.max(sellpre, price + buypre);
                if (sellpre <= price + buypre)
                    bought = false;
            } else {
                sell[i] = Math.max(sellpre,price +buypre);
                buy[i] = Math.max(buypre, sellpre - price);
                if(buypre<=sellpre-price)
                    bought = true;
            }

            // System.out.println(bought+" "+i+"   "+sell[i]+","+buy[i]);
        }
        return Math.max(sell[len - 1], buy[len - 1]);
    }
}
