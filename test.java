import java.util.*;
public class test {

    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = (int) (Math.pow(10,i-1) + Math.pow(9,i-1)*(i-1));
        }
        return (int)Math.pow(10,n) - dp[n-2]*9 -dp[n-1]*9;
    }

    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.countNumbersWithUniqueDigits(4));
    }
}
