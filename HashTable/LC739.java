package HashTable;

import java.util.Stack;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];
            if (cur <= pre) {
                stack.push(i);
                pre = cur;
                continue;
            }
            while (true) {
                int beforeDay = stack.pop();
                int beforeTemp = temperatures[beforeDay];
                if (beforeTemp >= cur) {
                    stack.push(i);
                    pre = cur;
                    break;
                }
                ans[beforeDay] = i - beforeDay;
            }
        }
        return ans;
    }
}
