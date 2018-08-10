package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int freq = map.getOrDefault(cur, 0) + 1;
            max = Math.max(max, freq);
            map.put(cur, freq);
        }
        HashMap<Integer, Integer> start = new HashMap<>(), end = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (Map.Entry e:map.entrySet()) {
            if((int)e.getValue()==max)
                set.add((int) e.getKey());
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(set.contains(cur)){
                if(!start.containsKey(cur))
                    start.put(cur,i);
            }
            if (set.size()==start.size())
                break;
        }
        for (int i = nums.length-1; i >= 0; i--) {
            int cur = nums[i];
            if(set.contains(cur)){
                if(!end.containsKey(cur))
                    end.put(cur,i);
            }
            if (set.size()==end.size())
                break;
        }
        int min = Integer.MAX_VALUE;
        for (int key : start.keySet()) {
            min = Math.min(end.get(key) - start.get(key),min);
        }
        return min;
        
    }
}
