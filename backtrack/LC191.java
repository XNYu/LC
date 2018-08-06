package backtrack;

public class LC191 {
    public int hammingWeight(int n) {
        int cur = 1;
        int count = 0;
        while (cur<n)
        {
            count++;
            cur *= 2;
        }
        System.out.println(count);
        return 1;
    }

    public static void main(String[] args) {
        LC191 l = new LC191();
        l.hammingWeight(11);
//        System.out.println(Integer.bitCount(128));
    }
}
