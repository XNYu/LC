package HashTable;

import java.util.HashMap;

public class LC760 {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> a = new HashMap<>();
        int[] ans = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            a.put(B[i], i);
        }
        for (int i = 0; i < A.length; i++) {
            ans[i] = a.get(A[i]);
        }
        return ans;
    }
}
