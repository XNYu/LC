package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        back( n, "", 0,n);
        return ans;
    }

    public void back(int n, String str, int cur, int pre) {
        if (str.length()==2*n) {
            ans.add(str);
            return;
        }
        if (pre!=0) {
            StringBuilder sb = new StringBuilder(str);
            sb.append("(");
            pre -= 1;
            back(n, sb.toString(), cur + 1,pre);
            pre += 1;
        }
        if (cur > 0) {
            str += ")";
            back(n, str, cur-1,pre);
        }
    }

    public static void main(String[] args) {
        LC22 l = new LC22();
        System.out.println(l.generateParenthesis(3));
    }
}
