package HashTable;

public class LC205 {
    public boolean isIsomorphic(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] positionS = new int[128], positionT = new int[128];
        int count = 1;
        for (char c : cs) {
            if (positionS[c] == 0) {
                positionS[c] = count;
                count++;
            }
        }
        count = 1;
        for (char c : ct) {
            if (positionT[c] == 0) {
                positionT[c] = count;
                count++;
            }
        }
        for (int i = 0; i < cs.length; i++) {
            char ccs = cs[i];
            char cct = ct[i];
            if(positionS[ccs]!=positionT[cct])
                return false;
        }
        return true;
    }
}
