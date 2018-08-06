package dp;

import java.util.*;

public class lc638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return process(price, special, needs);
    }

    public int process(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int min = getMin(price, needs);
        for (List<Integer> offer : special) {
            if (!isValid(needs, offer)) {
                continue;
            }
            LinkedList<Integer> backUp = new LinkedList<>(needs);
            for (int i = 0; i < backUp.size(); i++) {
                backUp.set(i, backUp.get(i) - offer.get(i));
            }
            min = Math.min(min, offer.get(offer.size() - 1) + process(price, special, backUp));
        }
        return min;
    }

    public int getMin(List<Integer> price, List<Integer> needs) {
        int min = 0;
        for (int i = 0; i < price.size(); i++) {
            min += price.get(i) * needs.get(i);
        }
        return min;
    }

    public boolean isValid(List<Integer> need, List<Integer> offer) {
        for (int j = 0; j < need.size(); j++) {
            if (need.get(j) < offer.get(j) ) {
                return false;
            }
        }
        return true;
    }
}
