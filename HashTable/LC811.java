package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String visit : cpdomains) {
            String[] strs = visit.split(" ");
            int count = Integer.valueOf(strs[0]);
            String[] domains = strs[1].split("\\.");
            String d = domains[domains.length - 1];
            for (int i = domains.length-2; i >= 0; i--) {
                map.put(d, map.getOrDefault(d, 0) + count);
                d = domains[i] + "." + d;
            }
            map.put(d, map.getOrDefault(d, 0) + count);
        }
        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            String a = map.get(key) + " " + key;
            ans.add(a);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
