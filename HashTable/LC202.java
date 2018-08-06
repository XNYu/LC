package HashTable;

import java.util.HashSet;

public class LC202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            n = calc(n);
            System.out.println(n);
            if (n == 1) {
                return true;
            }
            if(!set.add(n))
                return false;
        }
    }

    public int calc(int n) {
        int ans = 0;
        while (n != 0) {
            int cur = n % 10;
            ans += cur * cur;
            n = n / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        LC202 l = new LC202();
        System.out.println(l.isHappy(198));
    }
}
