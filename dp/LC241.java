package dp;

import java.util.*;

public class LC241 {
    HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input))
            return map.get(input);
        String num = "";
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String pre = input.substring(0, i);
                String las = input.substring(i + 1);
//                System.out.println(pre+","+las);
                List<Integer> a = diffWaysToCompute(pre);
                List<Integer> b = diffWaysToCompute(las);
                for (int x : a) {
                    for (int y : b) {
//                        System.out.println(input+","+x+" "+y);
                        if(c=='-')
                            list.add(x - y);
                        else if(c=='+')
                            list.add(x + y);
                        else
                            list.add(x * y);
                    }
                }
            }
        }
        if(list.size()==0)
            list.add(Integer.valueOf(input));
//        System.out.println("input   "+input+" , "+list.size());
        map.put(input, list);
        return list;
    }

    public static void main(String[] args) {
        LC241 l = new LC241();
        LinkedList<Integer> list = (LinkedList<Integer>) l.diffWaysToCompute("3+2*23*32");
        for (int i : list) {
            System.out.print(i+" ");
        }
    }



}
