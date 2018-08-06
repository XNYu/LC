package DFS;

import java.util.*;

public class LC332 {
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    public List<String> findItinerary(String[][] tickets) {
        ArrayList<String> ans = new ArrayList<>();
        if(tickets.length==0)
            return ans;
        for (int i = 0; i < tickets.length; i++) {
            ArrayList<String> list = map.getOrDefault(tickets[i][0], new ArrayList<>());
            list.add(tickets[i][1]);
            map.put(tickets[i][0], list);
        }
        for (String key : map.keySet()) {
            ArrayList<String> l = map.get(key);
            Collections.sort(l);
            Collections.reverse(l);
            map.put(key, l);
            System.out.println(key+","+l);
        }

        String cur = "JFK";
        Stack<List<String>> stack = new Stack<>();
        ans.add(cur);
        Stack<String> prefix = new Stack<>();
        System.out.println();
        while (map.size() > 0) {
            String pre = cur;
            ArrayList<String> list = map.get(pre);
            System.out.println(pre+","+list);
            if(list==null)
            {
                System.out.println(ans);
                stack.push(ans);
                ans = new ArrayList<>();
//                cur = prefix.pop();
                cur = "JFK";
                ans.add(cur);
                continue;
            }
            if (list.size() > 0) {
                prefix.push(cur);
                cur = list.get(0);
                list.remove(cur);
            }
            if (list.size() == 0) {
                map.remove(pre);
            }
            ans.add(cur);
        }
        for (List<String> l : stack) {
            l.remove(0);
            ans.addAll(l);
        }
        for (String s : ans) {
            System.out.print(s+" ");
        }
        return ans;
    }

    public static void main(String[] args) {
        LC332 l = new LC332();
        String[][] strings = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        strings = new String[][]{{"JFK","A"},{"JFK","C"},{"C","JFK"},{"A","JFK"},{"JFK","B"}};
        strings = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        strings = new String[][]{{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},
                {"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        l.findItinerary(strings);
    }
}
