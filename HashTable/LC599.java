package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String cur = list2[i];
            if (map.containsKey(cur)) {
                int index = map.get(cur) + i;
                if(index<=min) {
                    ans.clear();
                    ans.add(cur);
                    min = index;
                }
            }
        }
        String[] a = new String[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }
        return a;
    }
}
