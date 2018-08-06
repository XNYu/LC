package UnionFind;

import java.util.*;

public class LC734 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        int len1 = words1.length;
        int len2 = words2.length;
        if(len1!=len2)
            return false;
        HashMap<String, ArrayList<String>> same = new HashMap<>();
        for (String[] pair : pairs) {
            String pre = pair[0];
            String cur = pair[1];
            ArrayList<String> s = same.getOrDefault(pre, new ArrayList<>());
            s.add(cur);
            same.put(pre, s);
            s = same.getOrDefault(cur, new ArrayList<>());
            s.add(pre);
            same.put(cur, s);
        }
        for (int i = 0; i < len1; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            if(w1.equals(w2))
                continue;
            if (!same.getOrDefault(w1, new ArrayList<>()).contains(w2) || !same.getOrDefault(w2, new ArrayList<>()).contains(w1)) {
                return false;
            }
        }
        return true;
    }
}
