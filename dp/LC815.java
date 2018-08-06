package dp;

import java.util.*;

public class LC815 {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    HashMap<Integer, HashMap<Integer, Integer>> minPath = new HashMap<>();
    int min = Integer.MAX_VALUE;
    int[][] routes;
    public int numBusesToDestination(int[][] routes, int S, int T) {
        this.routes = routes;
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                ArrayList<Integer> list = map.getOrDefault(stop, new ArrayList<>());
                list.add(i);
                map.put(stop, list);
            }
        }
        find(S, T, 0, new HashSet<>());
        return min;
    }

    public void find(int S, int T, int length, HashSet<Integer> set) {
        if(S==T)
        {
            min = Math.min(length, min);
        }
        ArrayList<Integer> buses = map.get(T);
//        System.out.println(T+","+buses);
        if (buses==null||buses.size() == 0) {
            return;
        } else {
            for (int bus : buses) {
                int[] stops = routes[bus];
                HashSet<Integer> s = new HashSet<>(set);
                if(s.add(bus))
                for (int stop : stops) {
                    find(S, stop, length + 1, s);
                }
            }
        }
    }

    public static void main(String[] args) {
        LC815 l = new LC815();
        int[][] buses = new int[][]{{1, 2, 7}, {3, 6, 7}};
        System.out.println(l.numBusesToDestination(buses,1,6));
    }

}
