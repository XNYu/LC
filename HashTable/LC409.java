package HashTable;

public class LC409 {
    public int longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int[] counts = new int[128];
        int ans = 0;
        for (char c : cs) {
            counts[c] += 1;
            if(counts[c]==2)
            {
                ans += 2;
                counts[c] = 0;
            }
        }
        boolean hasOne = false;
        for (int i : counts) {
            if(i==2)
                ans += 2;
            if (i == 1) {
                hasOne = true;
            }
        }
        if(hasOne)
            ans++;
        return ans;
    }
}
