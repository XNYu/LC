package HashTable;

public class LC389 {
    public char findTheDifference(String s, String t) {
        int i = 0;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] is = new int[128], it = new int[128];
        for (char c : cs) {
            is[c] += 1;
        }
        for (char c : ct) {
            it[c] += 1;
        }
        for (int j = 0; j < is.length; j++) {
            if (is[j] != it[j]) {
                return (char)j;
            }
        }
        return ' ';
    }
}
