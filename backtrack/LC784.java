package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC784 {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        back(S.toCharArray(), 0);
        return ans;
    }

    public void back(char[] str, int p) {
        while (p<str.length&&!isLetter(str[p])) {
            p++;
        }
        if (p>=str.length||!isLetter(str[p])) {
            String a = String.valueOf(str);
            ans.add(a);
            return;
        }
        char[] tmp = Arrays.copyOf(str,str.length);
        back(str, p+1);
        tmp[p] = trans(tmp[p]);
        back(tmp, p+1);
    }

    public char trans(char c) {
        if (c <= 'Z' && c >= 'A') {
            int cc = (int) c + 32;
            return (char) cc;
        } else {
            return (char) ((int) c - 32);
        }
    }

    public boolean isLetter(char c) {
        if (c <= 'Z' && c >= 'A' || (c <= 'z' && c >= 'a')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC784 l = new LC784();
        String test = "3z4";
        System.out.println(l.letterCasePermutation(test));
    }
}
