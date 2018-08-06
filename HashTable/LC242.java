package HashTable;

public class LC242 {
    public boolean isAnagram(String s, String t) {
        int[] timess = new int[200];
        int[] timest = new int[200];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (char c : sc) {
            timess[c] += 1;
        }
        for (char c : tc) {
            timest[c] += 1;
        }
        for (int i = 0; i < timess.length; i++) {
            if(timess[i]!=timest[i])
                return false;
        }
        return true;
    }
}
