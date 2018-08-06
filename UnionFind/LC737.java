package UnionFind;

import java.util.*;

public class LC737 {

    public String find(String str, HashMap<String, String> map) {
        while (!str.equals(map.getOrDefault(str,str))) {
            str = map.get(str);
        }
        return str;
    }
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        int len1 = words1.length;
        int len2 = words2.length;
        if(len1!=len2)
            return false;
        HashMap<String, String> parent = new HashMap<>();
        for (String[] pair : pairs) {
            String pre = pair[0];
            String cur = pair[1];
            String rp = find(pre, parent);
            String rc = find(pre, parent);
            parent.put(rp, rc);
        }
        for (int i = 0; i < len1; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            if(!find(w1,parent).equals(find(w2,parent)))
                return false;
        }
        return true;
    }

}
