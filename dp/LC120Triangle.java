package dp;

import java.util.Arrays;
import java.util.List;
import java.util.*;

public class LC120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            ArrayList<Integer> list = (ArrayList<Integer>) triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                int cur = list.get(j);
                if(j==list.size()-1)
                    dp[i][j] = cur + dp[i - 1][j - 1];
                else if(j==0)
                    dp[i][j] = cur + dp[i - 1][0];
                else
                    dp[i][j] = cur+Math.min(dp[i-1][j],dp[i-1][j-1]);
                System.out.println(dp[i][j]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, dp[len - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        ArrayList<Integer> c = new ArrayList<>();
        a.add(2);
        c.add(3);
        c.add(4);
        list.add(a);
        list.add(b);
        list.add(c);
        LC120Triangle t = new LC120Triangle();
        System.out.println(t.minimumTotal(list));

    }

}
