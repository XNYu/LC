package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LC56 {
    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });
        Interval pre;
        List<Interval> ans = new ArrayList<>();
        for (int i = 0; i < intervals.size()-1; i++) {
            pre = intervals.get(i);
            Interval cur = intervals.get(i + 1);
            if (pre.end >= cur.start) {
                cur.start = Math.min(pre.start, cur.start);
                cur.end = Math.max(pre.end, cur.end);
            } else {
                ans.add(pre);
            }
        }
        return ans;
    }
}
