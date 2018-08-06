package HashTable;

import java.util.*;

public class LC356 {
    public boolean isReflected(int[][] points) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int[] o : points) {
            ArrayList<Integer> xCoordinate = map.getOrDefault(o[1], new ArrayList<Integer>());
            xCoordinate.add(o[0]);
            map.put(o[1],xCoordinate);
        }
        double y = 0;
        boolean hasY = false;
        for (Map.Entry e : map.entrySet()) {
            ArrayList<Integer> list = (ArrayList<Integer>) e.getValue();
            TreeSet<Integer> set = new TreeSet<>(list);
            int size = set.size();
            while (!set.isEmpty()){
                double pre=Double.MAX_VALUE,cur = Double.MAX_VALUE;
                if (set.size() > 1) {
                    pre = set.pollFirst();
                    cur = set.pollLast();
                    if (!hasY) {
                        y = (cur + pre) / 2;
                        hasY = true;
                    } else {
                        if ((cur + pre) != 2 * y) {
                            return false;
                        }
                    }
                } else if (set.size() == 1) {
                    if (!hasY) {
                        y = set.pollFirst();
                    } else {
                        if (set.pollFirst() != y) {
                            return false;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return true;
//        Arrays.sort(points, ((o1, o2) -> {
//            if(o1[1]==o2[1])
//                return o1[0] - o2[0];
//            return o1[1] - o2[1];
//        }));

    }

}
