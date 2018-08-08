package HashTable;

import java.util.HashMap;

public class LC447 {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            map = new HashMap<>();
            for (int j = i+1; j < points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                int x = p2[0] - p1[0];
                int y = p2[1] - p1[1];
                int dist = x * x + y * y;
                map.put(dist, map.getOrDefault(dist, 0));
            }
            for (int d:map.values())
                count += d * (d - 1);
        }
        return count;
    }

}
