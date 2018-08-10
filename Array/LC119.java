package Array;

import java.util.ArrayList;
import java.util.List;

public class LC119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        ans.add(1);
        ans.add(1);
        if(rowIndex==0)
            return tmp;
        if(rowIndex==1)
            return ans;
        for (int i = 2; i <= rowIndex; i++) {
            tmp = new ArrayList<>(ans);
            ans.clear();
            ans.add(1);
            for (int j = 1; j < i; j++) {
                ans.add(tmp.get(j) + tmp.get(j - 1));
            }
            ans.add(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC119 l = new LC119();
        System.out.println(l.getRow(4));
    }
}
