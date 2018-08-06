package HashTable;

public class LC771 {
    public int numJewelsInStones(String J, String S) {
        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();
        int[] jewery = new int[250];
        int count = 0;
        for (char c : ss) {
            jewery[c] += 1;
        }
        for (char c : js) {
            count += jewery[c];
        }
        return count;
    }
    public int numJewelsInStones2(String J, String S) {
        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();
        int[] jewery = new int[250];
        int count = 0;
        for (char c : js) {
            jewery[c] = 1;
        }
        for (char c : ss) {
            if (jewery[c] != 0) {
                count++;
            }
        }
        return count;
    }
}
