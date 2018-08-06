package backtrack;

public class LC60 {

    public String getPermutation(int n, int k) {
        int[] fact = new int[n+1];
        fact[0] = 1;
        for (int i = 1; i < n+1; i++) {
            fact[i] = fact[i - 1] * i;
        }
        if(k>fact[n])
            return "";
        boolean[] visited = new boolean[n];
        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            int cur = 0;
            int curFact = fact[n - sb.length() - 1];
            for (int i = 1; i < n+1; i++) {
                if (visited[i-1]) {
                    continue;
                }
                cur++;
                if (cur * curFact >= k) {
                    visited[i - 1] = true;
                    k -= (cur-1) * curFact;
                    cur = i;
                    break;
                }
            }
            sb.append(cur);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC60 l = new LC60();
        System.out.println(l.getPermutation(4, 10));
    }


}
