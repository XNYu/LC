package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        int[] chars = new int[26];
        for (String s : strs) {
            chars = new int[250];
            char[] cs = s.toCharArray();
            for (char c : cs) {
                chars[c-97] += 1;
            }
            String hashStr = "";
            StringBuilder sb = new StringBuilder(hashStr);
            for (int i : chars) {
                sb.append(i).append("#");
            }
            hashStr = sb.toString();

            ArrayList<String> list = map.getOrDefault(hashStr, new ArrayList<>());
            list.add(s);
            map.put(hashStr, list);
        }
        List<List<String >> ans = new ArrayList<>();
        for (Map.Entry e : map.entrySet()) {
            ans.add((List<String>) e.getValue());
        }
        return ans;
    }

    public boolean same(int[] i1,int[] i2) {
        for (int i = 0; i < i1.length; i++) {
            if(i1[i]!=i2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
