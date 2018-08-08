package HashTable;

import java.util.*;

public class LC692 {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.getValue()==o2.getValue())
                return ((String)o1.getKey()).compareTo((String) o2.getKey());
            return (int) o2.getValue() - (int) o1.getValue();
        });
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry e : map.entrySet()) {
            queue.offer(e);
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add((String) queue.poll().getKey());
        }
        return ans;
    }
}
