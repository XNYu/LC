package Design;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashSet<Integer> set;
    /** Initialize your data structure here. */
    public TwoSum() {
        set = new HashSet<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        set.add(number);
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i : set) {
            int minus = value - i;
            if (minus == i) {
                if (freq.get(i) > 1)
                    return true;
            } else if (set.contains(minus)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        t.add(1);
        t.add(3);
        t.add(5);
        System.out.println(t.find(4));
        System.out.println(t.find(2));
    }
}
