package dp;

public class LC474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        int index = 0;
        for (String s : strs) {
            System.out.println(++index);
            int count1=0,count0=0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1') {
                    count1++;
                } else {
                    count0++;
                }
            }
            if(count0>m||count1>n)
                continue;
            System.out.println("'"+s+"'  "+count0+","+count1);
            int cur = Math.max(dp[count0][count1], 1);
            int[][] temp = dp;
            for (int i = m; i >= 0 ; i--) {
                for (int j = n; j >= 0; j--) {
                    int count = dp[i][j];
                    if(count==0)
                        continue;
                    if ((count0 + i) <= m && (count1 + j) <= n) {
                        count = 1 + count;
                        temp[count0 + i][count1 + j] = Math.max(temp[count0 + i][count1 + j],count);
                    }
                    max = Math.max(max, count);
                }
            }
            dp = temp;
            dp[count0][count1] = cur;
            max = Math.max(max, cur);
            print(dp);
            System.out.println();
        }
        return max;
    }

    public void print(int[][] dp) {
        for (int i = 0; i < dp[0].length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j][i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LC474 l = new LC474();

        String[] strs = new String[]{"0001","0101","1000","1000"};
        System.out.println(l.findMaxForm(strs,9,3));
    }

}
