package HashTable;

import java.util.Arrays;

public class LC274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 1;
        for (int i = citations.length-1; i >= 0; i--) {
            int cit = citations[i];
            if (cit >= h) {
                h++;
            } else {
                break;
            }
        }
        return h - 1;
    }

    public static void main(String[] args) {
        LC274 l = new LC274();
        int[] nums = new int[]{3, 0, 6, 1, 5};
        System.out.println(l.hIndex(nums));
    }
}
