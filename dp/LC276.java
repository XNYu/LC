package dp;

public class LC276 {

    public int numWays(int n, int k) {
        if(n==1)
            return k;
        if(n==2)
            return k * k;
        int diff = k*(k-1);
        int same = k;
        int total = diff+same;
        for (int i = 2; i < n; i++) {
            same = diff;
            diff = total*(k-1);
            total = diff+same;
        }
        return total;
    }

    public static void main(String[] args) {
        LC276 l = new LC276();
        System.out.println(l.numWays(4,2));
    }
}
