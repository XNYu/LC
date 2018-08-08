package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        if (index == list.size() - 1) {
            list.remove(index);
            map.remove(val);
            return true;
        }
        int last = list.get(list.size() - 1);
        list.set(index, last);
        list.remove(list.size() - 1);
        map.remove(val);
        map.put(last, index);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet s = new RandomizedSet();
        System.out.println(s.insert(0));
        System.out.println(s.map);
        System.out.println(s.list);
        System.out.println(s.remove(0));
        System.out.println(s.map);
        System.out.println(s.list);
        System.out.println(s.insert(-1));
        System.out.println(s.map);
        System.out.println(s.list);
        System.out.println(s.remove(0));
        System.out.println(s.map);
        System.out.println(s.list);
        System.out.println(s.getRandom());
    }
}
