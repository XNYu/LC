package HashTable;

import java.util.*;

public class LC249 {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            if (s.length() != 0)
            {
                StringBuilder sb = new StringBuilder();
                char pre = s.charAt(0);
                for (int i = 1; i < s.length(); i++) {
                    char cur = s.charAt(i);
                    int minus = cur - pre;
                    if (minus < 0) {
                        minus += 26;
                    }
                    sb.append('a' + minus);
                    pre = cur;
                }
                String hash = sb.toString();
                map.putIfAbsent(hash, new ArrayList<>());
                map.get(hash).add(s);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry e : map.entrySet()) {
            ans.add((ArrayList<String>)e.getValue());
        }
        return ans;
    }
}
