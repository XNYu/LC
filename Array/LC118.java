package Array;

import java.util.ArrayList;
import java.util.List;

public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> add = new ArrayList<>();
            add.add(1);
            for (int j = 0; j < pre.size()-1; j++) {
                add.add(pre.get(j) + pre.get(j + 1));
            }
            if(i>0)
                add.add(1);
            ans.add(add);
            pre = add;
        }
        return ans;
    }

    public static void main(String[] args) {
        LC118 l = new LC118();
        System.out.println(l.generate(5));
    }
}
