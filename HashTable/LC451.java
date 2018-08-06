package HashTable;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC451 {
    class L {
        int frequency;
        char letter;

        public L(int frequency, char letter) {
            this.frequency = frequency;
            this.letter = letter;
        }
    }
    public String frequencySort(String s) {
        char[] cs = s.toCharArray();
        int[] is = new int[128];
        PriorityQueue<L> queue = new PriorityQueue<>(new Comparator<L>() {
            @Override
            public int compare(L o1, L o2) {
                return o2.frequency-o1.frequency;
            }
        });
        for (char c : cs) {
            is[c] += 1;
        }
        for (int i = 0; i < is.length; i++) {
            int frequency = is[i];
            L l = new L(frequency, (char) i);
            queue.offer(l);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            L l = queue.poll();
            for (int i = 0; i < l.frequency; i++) {
                sb.append(l.letter);
            }
        }
        return sb.toString();
    }
}
